package dhhighschool.studentmanagedh.controller;

import dhhighschool.studentmanagedh.dao.*;
import dhhighschool.studentmanagedh.model.Student;
import dhhighschool.studentmanagedh.model.TestScores;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiConsumer;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IRoleDAO rolesDAO;
    private IClassDAO classDAO;
    private String errors = "";
    private IStudentDAO studentDAO;
    private ISubjectDAO subjectDAO;
    private ITestScoreDAO testScoreDAO;
    private IRoleDAO roleDAO;


    public void init() {
        studentDAO = new StudentDAO ();
        rolesDAO = new RoleDAO ();
        classDAO = new ClassDAO ();
        subjectDAO = new SubjectDAO ();
        testScoreDAO = new TestScoreDAO ();
        roleDAO = new RoleDAO ();
        if ( this.getServletContext ().getAttribute ( "listRole" ) == null ) {
            this.getServletContext ().setAttribute ( "listRole", rolesDAO.selectAllRoles () );
        }
        if ( this.getServletContext ().getAttribute ( "listClass" ) == null ) {
            this.getServletContext ().setAttribute ( "listClass", classDAO.selectAllClass () );
        }
        if ( this.getServletContext ().getAttribute ( "listSubjects" ) == null ) {
            this.getServletContext ().setAttribute ( "listSubjects", subjectDAO.selectAllSubjectDAO () );
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType ( "text/html;charset=UTF-8" );
        request.setCharacterEncoding ( "utf-8" );
        String action = request.getParameter ( "action" );
        if ( action == null ) {
            action = "";
        }

        try {
            switch (action) {
                case "add":
                    showAddForm ( request, response );
                    break;
                case "update":
                    showUpdateForm ( request, response );
                    break;
                case "remove":
                    removeStudent ( request, response );
                    break;
                case "delete":
                    deleteStudent ( request, response );
                    break;
                case "restore":
                    restoreStudent ( request, response );
                    break;
                case "list":
                    listAllStudentsPage ( request, response );
//                    searchAllField ( request,response );
                    break;
                case "listTrash":
                    listTrashStudents ( request, response );
                    break;
                case "score":
                    showAddScoreForm ( request, response );
                    break;
                case "leaderboard":
                    listLeaderboardStudents ( request, response );
                    break;
                case "profile":
                    showProfile ( request, response );
                    break;
                case "search":
                    searchAllField ( request, response );
                    break;
                case "classes":
                    listClassStudents ( request, response );
                    break;
                default:
//                    searchAllField ( request, response );
                    homePage ( request, response );
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException ( ex );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType ( "text/html;charset=UTF-8" );
        request.setCharacterEncoding ( "utf-8" );
        String action = request.getParameter ( "action" );
        if ( action == null ) {
            action = "";
        }

        try {
            switch (action) {
                case "add":
//                    insertStudent ( request, response );
                    insertStudentVali ( request, response );
                    break;
                case "update":
                    updateStudent ( request, response );
                    break;
                case "score":
                    addScoreVali ( request, response );
                    break;
//                case "classes":
//                    listClassStudents ( request, response );
//                    break;
                default:
                    listAllStudentsPage ( request, response );
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException ( ex );
        }
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/index.jsp" );
        dispatcher.forward ( request, response );
    }

/// List all student
    private void listAllStudentsPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int page = 1;
        int recordsPerPage = 10;
        if ( request.getParameter ( "page" ) != null )
            page = Integer.parseInt ( request.getParameter ( "page" ) );
        StudentDAO dao = new StudentDAO ();
        List<Student> list = dao.viewAllStudent ( (page - 1) * recordsPerPage,
                recordsPerPage );
        int noOfRecords = dao.getNoOfRecords ();
        int noOfPages = (int) Math.ceil ( noOfRecords * 1.0 / recordsPerPage );
        request.setAttribute ( "listStudent", list );
        request.setAttribute ( "noOfPages", noOfPages );
        request.setAttribute ( "currentPage", page );
        RequestDispatcher view = request.getRequestDispatcher ( "/WEB-INF/admin/student/list.jsp" );
        view.forward ( request, response );
    }
    //search student
    private void searchAllField(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int page = 1;
        int recordsPerPage = 5;
        if ( request.getParameter ( "page" ) != null ) {
            page = Integer.parseInt ( request.getParameter ( "page" ) );
        }
        String name = "";
        if ( !request.getParameter ( "search" ).trim ().equals ( "" ) ) {
            name = request.getParameter ( "search" );
            List<Student> listStudent = studentDAO.searchStudent ( (page - 1) * recordsPerPage, recordsPerPage, name );
            int noOfRecords = studentDAO.getNoOfRecords ();
            int noOfPages = (int) Math.ceil ( noOfRecords * 1.0 / recordsPerPage );
            request.setAttribute ( "listStudent", listStudent );
            request.setAttribute ( "noOfPages", noOfPages );
            request.setAttribute ( "currentPage", page );
            request.setAttribute ( "search", name );


            RequestDispatcher requestDispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/student/list.jsp" );
            requestDispatcher.forward ( request, response );
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher ( "/students?action=list" );
            requestDispatcher.forward ( request, response );
        }
    }
    // List class Student
    private void listClassStudents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int page = 1;
        int recordsPerPage = 5;
        if ( request.getParameter ( "page" ) != null ) {
            page = Integer.parseInt ( request.getParameter ( "page" ) );
        }
        int classID = Integer.parseInt ( request.getParameter ( "classes" ) );
        if ( classID == 0 ) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher ( "/students?action=list" );
            requestDispatcher.forward ( request, response );
        } else {
            List<Student> listClassStudent = studentDAO.selectListClassStudent ( (page - 1) * recordsPerPage, recordsPerPage, classID );
            int noOfRecords = studentDAO.getNoOfRecords ();
            int noOfPages = (int) Math.ceil ( noOfRecords * 1.0 / recordsPerPage );
            request.setAttribute ( "listClassStudent", listClassStudent );
            request.setAttribute ( "noOfPages", noOfPages );
            request.setAttribute ( "currentPage", page );
            request.setAttribute ( "classes", classID );


            RequestDispatcher requestDispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/student/listClass.jsp" );
            requestDispatcher.forward ( request, response );
        }
    }
    private void listTrashStudents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> listStudent = studentDAO.selectTrashListStudent ();
        request.setAttribute ( "listStudent", listStudent );
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/student/listTrash.jsp" );
        dispatcher.forward ( request, response );
    }

    // ADD STUDENT
    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println ( "Servlet path: " + this.getServletContext ().getRealPath ( "/" ) );
        List<Student> listStudent = studentDAO.selectAllStudent ();
        request.setAttribute ( "listStudent", listStudent );
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/student/add.jsp" );
        dispatcher.forward ( request, response );
    }

    private void insertStudentVali(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Student student = new Student ();
        boolean flag = true;
        Map<String, String> hashMap = new HashMap<String, String> ();
        String code = newS_code ();
        String firstName = request.getParameter ( "firstName" );
        String lastName = request.getParameter ( "lastName" );
        String birthday = request.getParameter ( "birthday" );
        String email = request.getParameter ( "email" );
        String phone = request.getParameter ( "phone" );
        String address = request.getParameter ( "address" );
        String avatar = null;
        int classes_id = Integer.parseInt ( request.getParameter ( "classes" ) );
        int role_id = Integer.parseInt ( request.getParameter ( "role" ) );
        if ( role_id == 1 ) {
            student.setClass_id ( 100 );
        } else {
            student.setClass_id ( classes_id );
        }
        student.setRole_id ( Integer.parseInt ( request.getParameter ( "role" ) ) );

        try {
            student.setCode ( code );
            student.setFirstName ( firstName );
            student.setLastName ( lastName );
            student.setDayBirth ( birthday );
            student.setEmail ( email );
            student.setPhoneNum ( phone );
            student.setAddress ( address );
            for (Part part : request.getParts ()) {
                if ( part.getName ().equals ( "file" ) ) {
                    String fileName = extractFileName ( part );
                    // refines the fileName in case it is an absolute path
                    fileName = new File ( fileName ).getName ();
                    if ( fileName.equals ( "" ) ) {
                        avatar = "\\assets\\images\\avatardefault.png";
                        student.setAvatar ( avatar );
                    } else {
                        String servletRealPath = this.getServletContext ().getRealPath ( "/" ) + "\\images\\" + fileName;
                        part.write ( "D:\\CODEGYM\\MODULE_3\\CaseStudy\\StudentManageDH\\src\\main\\webapp\\images\\" + fileName );
                        part.write ( servletRealPath );
                        System.out.println ( servletRealPath );
                        avatar = "\\images\\" + fileName;
                        student.setAvatar ( avatar );
                    }
                }
            }

//            student.setClass_id ( Integer.parseInt ( request.getParameter ( "classes" ) ) );

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory ();
            Validator validator = validatorFactory.getValidator ();
            Set<ConstraintViolation<Student>> constraintViolations = validator.validate ( student );

            if ( !constraintViolations.isEmpty () ) {
                errors = "<div>";
                for (ConstraintViolation<Student> constraintViolation : constraintViolations) {
                    errors += "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                            "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                            "<strong>" + constraintViolation.getPropertyPath () + "!</strong>" + " " + constraintViolation.getMessage () + "</div>";
                }
                errors += "</div>";

                request.setAttribute ( "student", student );
                request.setAttribute ( "errors", errors );
                request.setAttribute ( "firstName", firstName );
                request.setAttribute ( "lastName", lastName );
                request.setAttribute ( "birthday", birthday );
                request.setAttribute ( "email", email );
                request.setAttribute ( "phone", phone );
                request.setAttribute ( "address", address );
                request.setAttribute ( "avatar", avatar );

                request.getRequestDispatcher ( "/WEB-INF/admin/student/add.jsp" ).forward ( request, response );
            } else {
                if ( studentDAO.selectStudent ( code ) == null) {
                    flag = false;
                    hashMap.put ( "student", "Not Exists role id!" );
                }
                if ( studentDAO.selectStudentByPhone ( phone ) != null ) {
                    flag = false;
                    hashMap.put ( "phone", "Phone number already exist!" );
                }
                if ( studentDAO.selectStudentByEmail ( email ) != null ) {
                    flag = false;
                    hashMap.put ( "email", "Email already exist!" );
                }
                if ( role_id != 1 && role_id != 2) {
                    flag = false;
                    hashMap.put ( "role id", "Not Exists role id!" );
                }
//                String catagoryRaw = request.getParameter("role");
//                int catagory;
//                try {
//                    catagory = Integer.parseInt(catagoryRaw);
//                    if (!roleDAO.checkRoleById (catagory)) {
//                        throw new IOException();
//                    }
//                } catch (NumberFormatException | IOException e) {
//                    hashMap.put ( "role id", "Not Exists role id!" );
//                }
                if ( studentDAO.selectStudentByEmail ( email ) != null ) {
                    flag = false;
                    hashMap.put ( "email", "Email already exist!" );
                }
                SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy-MM-dd" );
                Date dateinput = sdf.parse ( birthday );
                int compareTime = dateinput.compareTo ( Date.from ( Instant.now () ) );
                if ( compareTime > 0 ) {
                    flag = false;
                    hashMap.put ( "birthday", "Birthday invalid! Not exceed the current time" );
                }
                if ( flag ) {
                    studentDAO.insertStudent ( student );

                    Student s = new Student ();
                    request.setAttribute ( "student", s );
                    hashMap.put ( "done", "Add new student success." );
                    errors = "<div>";
                    hashMap.forEach ( new BiConsumer<String, String> () {
                        @Override
                        public void accept(String keyError, String valueError) {
                            errors += "<div class=\"alert alert-success alert-dismissible fade show\">\n" +
                                    "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" + "<strong>" + valueError
                                    + "</strong></div>";
                        }
                    } );
                    errors += "</div>";
                    request.setAttribute ( "student", student );
                    request.setAttribute ( "errors", errors );
                    request.getRequestDispatcher ( "/WEB-INF/admin/student/add.jsp" ).forward ( request, response );
                } else {
                    errors = "<div>";
                    hashMap.forEach ( new BiConsumer<String, String> () {
                        @Override
                        public void accept(String keyError, String valueError) {
                            errors += "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                    "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" + "<strong>" + valueError
                                    + "!</strong></div>";
                        }
                    } );
                    errors += "</div>";
                    request.setAttribute ( "student", student );
                    request.setAttribute ( "errors", errors );
                    request.setAttribute ( "firstName", firstName );
                    request.setAttribute ( "lastName", lastName );
                    request.setAttribute ( "birthday", birthday );
                    request.setAttribute ( "email", email );
                    request.setAttribute ( "phone", phone );
                    request.setAttribute ( "address", address );
                    request.setAttribute ( "avatar", avatar );

                    System.out.println ( this.getClass () + " !constraintViolations.isEmpty()" );
                    request.getRequestDispatcher ( "/WEB-INF/admin/student/add.jsp" ).forward ( request, response );
                }
            }
        } catch (NumberFormatException e) {
            errors = "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                    "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n";
            errors += "<strong>" + "Input format not right"
                    + "!</strong>";

            errors += "</div>";

            request.setAttribute ( "student", student );
            request.setAttribute ( "errors", errors );
            request.setAttribute ( "student", student );
            request.setAttribute ( "errors", errors );
            request.setAttribute ( "firstName", firstName );
            request.setAttribute ( "lastName", lastName );
            request.setAttribute ( "birthday", birthday );
            request.setAttribute ( "email", email );
            request.setAttribute ( "phone", phone );
            request.setAttribute ( "address", address );
            request.setAttribute ( "avatar", avatar );

            request.getRequestDispatcher ( "/WEB-INF/admin/student/add.jsp" ).forward ( request, response );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    //    UPDATE STUDENT
    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Map<String, String> hashMap = new HashMap<String, String> ();

        String code = request.getParameter ( "code" );
        Student existingUser = studentDAO.selectStudent ( code );
        if ( studentDAO.selectStudent ( code ) == null) {
            hashMap.put ( "student", "Not Exists Student!" );
            errors = "<div>";
            hashMap.forEach ( new BiConsumer<String, String> () {
                @Override
                public void accept(String keyError, String valueError) {
                    errors += "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                            "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" + "<strong>" + valueError
                            + "</strong></div>";
                }
            } );
            errors += "</div>";
            request.setAttribute ( "student", existingUser );
            request.setAttribute ( "errors", errors );
            RequestDispatcher dispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/student/update.jsp" );
            dispatcher.forward ( request, response );
        } else {
            request.setAttribute ( "code", existingUser.getCode () );
            request.setAttribute ( "firstName", existingUser.getFirstName () );
            request.setAttribute ( "lastName", existingUser.getLastName () );
            request.setAttribute ( "birthday", existingUser.getDayBirth () );
            request.setAttribute ( "email", existingUser.getEmail () );
            request.setAttribute ( "phoneNum", existingUser.getPhoneNum () );
            request.setAttribute ( "address", existingUser.getAddress () );
            request.setAttribute ( "avatar", existingUser.getAvatar () );
            int classId = existingUser.getClass_id ();
            String className = classDAO.selectClasses ( classId ).getClassName ();
            request.setAttribute ( "classes", className );

            RequestDispatcher dispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/student/update.jsp" );

            dispatcher.forward ( request, response );
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Student student = new Student ();
        boolean flag = true;
        Map<String, String> hashMap = new HashMap<String, String> ();
        try {
            String code = request.getParameter ( "code" );
            String firstName = request.getParameter ( "firstName" );
            String lastName = request.getParameter ( "lastName" );
            String birthday = request.getParameter ( "birthday" );
//        String emailF = request.getParameter ( "emailF" );
//        String emailL = request.getParameter ( "emailL" );
            String email = request.getParameter ( "email" );
            String phone = request.getParameter ( "phoneNum" );
            String address = request.getParameter ( "address" );
            String avatar = null;
            int classId = Integer.parseInt ( request.getParameter ( "classes" ) );
            Timestamp updateDate = Timestamp.valueOf ( LocalDateTime.now () );
            for (Part part : request.getParts ()) {
                if ( part.getName ().equals ( "file" ) ) {
                    String fileName = extractFileName ( part );
                    // refines the fileName in case it is an absolute path
                    fileName = new File ( fileName ).getName ();
                    if ( fileName.equals ( "" ) ) {
                        avatar = request.getParameter ( "avatar" );
                    } else {
                        String servletRealPath = this.getServletContext ().getRealPath ( "/" ) + "\\images\\" + fileName;
                        part.write ( "D:\\CODEGYM\\MODULE_3\\CaseStudy\\StudentManageDH\\src\\main\\webapp\\images\\" + fileName );
                        part.write ( servletRealPath );
                        System.out.println ( servletRealPath );
                        avatar = "\\images\\" + fileName;
                    }
                }
            }
            student = new Student ( code, firstName, lastName, birthday, email, phone, address, avatar, classId, updateDate );
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory ();
            Validator validator = validatorFactory.getValidator ();
            Set<ConstraintViolation<Student>> constraintViolations = validator.validate ( student );

            if ( !constraintViolations.isEmpty () ) {
                errors = "<div>";
                for (ConstraintViolation<Student> constraintViolation : constraintViolations) {
                    errors += "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                            "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                            "<strong>" + constraintViolation.getPropertyPath () + "!</strong>" + " " + constraintViolation.getMessage () + "</div>";
                }
                errors += "</div>";

                request.setAttribute ( "student", student );
                request.setAttribute ( "errors", errors );
                request.setAttribute ( "firstName", firstName );
                request.setAttribute ( "lastName", lastName );
                request.setAttribute ( "birthday", birthday );
                request.setAttribute ( "email", email );
                request.setAttribute ( "phoneNum", phone );
                request.setAttribute ( "address", address );
                request.setAttribute ( "file", avatar );

                request.getRequestDispatcher ( "/WEB-INF/admin/student/update.jsp" ).forward ( request, response );
            }else {
                if ( studentDAO.selectStudent ( code ) == null) {
                    flag = false;
                    hashMap.put ( "student", "Not Exists role id!" );
                }
                if ( studentDAO.selectStudentByPhone ( phone ) != null && !studentDAO.selectStudent ( code ).getPhoneNum ().equals ( phone ) ) {
                    flag = false;
                    hashMap.put ( "phone", "Phone number already exist!" );
                }
                if ( studentDAO.selectStudentByEmail ( email ) != null && !studentDAO.selectStudent ( code ).getEmail ().equals ( email )) {
                    flag = false;
                    hashMap.put ( "email", "Email already exist!" );
                }
                SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy-MM-dd" );
                Date dateinput = sdf.parse ( birthday );
                int compareTime = dateinput.compareTo ( Date.from ( Instant.now () ) );
                if ( compareTime > 0 ) {
                    flag = false;
                    hashMap.put ( "birthday", "Birthday invalid! Not exceed the current time" );
                }
                if ( flag ) {
                    studentDAO.updateStudent ( student );
                    hashMap.put ( "success", "Update successful." );
                    Student s = new Student ();
                    request.setAttribute ( "student", s );
                    errors = "<div>";
                    hashMap.forEach ( new BiConsumer<String, String> () {
                        @Override
                        public void accept(String keyError, String valueError) {
                            errors += "<div class=\"alert alert-success alert-dismissible fade show\">\n" +
                                    "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" + "<strong>" + valueError
                                    + "</strong></div>";
                        }
                    } );
                    errors += "</div>";
                    request.setAttribute ( "student", student );
                    request.setAttribute ( "errors", errors );
                    request.setAttribute ( "firstName", firstName );
                    request.setAttribute ( "lastName", lastName );
                    request.setAttribute ( "birthday", birthday );
                    request.setAttribute ( "email", email );
                    request.setAttribute ( "phoneNum", phone );
                    request.setAttribute ( "address", address );
                    request.setAttribute ( "avatar", avatar );
                    request.getRequestDispatcher ( "/WEB-INF/admin/student/update.jsp" ).include ( request, response );
                } else {
                    errors = "<div>";
                    hashMap.forEach ( new BiConsumer<String, String> () {
                        @Override
                        public void accept(String keyError, String valueError) {
                            errors += "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                    "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" + "<strong>" + valueError
                                    + "!</strong></div>";
                        }
                    } );
                    errors += "</div>";
                    request.setAttribute ( "student", student );
                    request.setAttribute ( "errors", errors );
                    request.setAttribute ( "firstName", firstName );
                    request.setAttribute ( "lastName", lastName );
                    request.setAttribute ( "birthday", birthday );
                    request.setAttribute ( "email", email );
                    request.setAttribute ( "phoneNum", phone );
                    request.setAttribute ( "address", address );
                    request.setAttribute ( "avatar", avatar );

                    System.out.println ( this.getClass () + " !constraintViolations.isEmpty()" );
                    request.getRequestDispatcher ( "/WEB-INF/admin/student/update.jsp" ).forward ( request, response );
                }
            }
        }catch (NumberFormatException e) {
            errors = "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                    "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n";
            errors += "<strong>" + "Input format not right"
                    + "!</strong>";

            errors += "</div>";

            request.setAttribute ( "student", student );
            request.setAttribute ( "errors", errors );

            request.getRequestDispatcher ( "/WEB-INF/admin/student/update.jsp" ).forward ( request, response );
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

    // DELETE STUDENT
    private void removeStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String code = request.getParameter ( "code" );
        studentDAO.removeStudent ( code );

        List<Student> listStudent = studentDAO.selectAllStudent ();
        request.setAttribute ( "listStudent", listStudent );
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/students?action=list" );
        dispatcher.forward ( request, response );
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String code = request.getParameter ( "code" );
        studentDAO.deleteStudent ( code );

        List<Student> listStudent = studentDAO.selectAllStudent ();
        request.setAttribute ( "listStudent", listStudent );
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/students?action=listTrash" );
        dispatcher.forward ( request, response );
    }

    private void restoreStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String code = request.getParameter ( "code" );
        studentDAO.restoreStudent ( code );

        List<Student> listStudent = studentDAO.selectAllStudent ();
        request.setAttribute ( "listStudent", listStudent );
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/students?action=listTrash" );
        dispatcher.forward ( request, response );
    }
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader ( "content-disposition" );
        String[] items = contentDisp.split ( ";" );
        for (String s : items) {
            if ( s.trim ().startsWith ( "filename" ) ) {
                return s.substring ( s.indexOf ( "=" ) + 2, s.length () - 1 );
            }
        }
        return "";
    }

    public File getFolderUpload() {
        File folderUpload = new File ( System.getProperty ( "user.home" ) + "/Uploads" );
        if ( !folderUpload.exists () ) {
            folderUpload.mkdirs ();
        }
        return folderUpload;
    }

    public String newS_code() {
        long numCode = System.currentTimeMillis () % 100000;
        return String.format ( "DHS-%06d", numCode );
    }

    // Add Score ------------------------------------------------------------------------------------------------------------
    private void showAddScoreForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String code = request.getParameter ( "code" );
        Student existingUser = studentDAO.selectStudent ( code );
        request.setAttribute ( "code", existingUser.getCode () );
        request.setAttribute ( "firstName", existingUser.getFirstName () );
        request.setAttribute ( "lastName", existingUser.getLastName () );
        request.setAttribute ( "dayBirth", existingUser.getDayBirth () );
        request.setAttribute ( "email", existingUser.getEmail () );
        request.setAttribute ( "phoneNum", existingUser.getPhoneNum () );
        request.setAttribute ( "address", existingUser.getAddress () );
        request.setAttribute ( "avatar", existingUser.getAvatar () );
        request.setAttribute ( "classes", existingUser.getClass_id () );

        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/student/addScore.jsp" );

        dispatcher.forward ( request, response );
    }

    private void addScoreVali(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        TestScores testScore = new TestScores ();
        boolean flag = true;
        Map<String, String> hashMap = new HashMap<String, String> ();
        String firstName = request.getParameter ( "firstName" );
        String lastName = request.getParameter ( "lastName" );

        try {
            String student_code = request.getParameter ( "code" );
            testScore.setStudent_code ( student_code );
            int subject_id = Integer.parseInt ( request.getParameter ( "subject" ) );
            testScore.setSubjects_id ( subject_id );
            float firstScore = Float.parseFloat ( request.getParameter ( "firstScore" ) );
            testScore.setF_testScore ( firstScore );
            float secondScore = Float.parseFloat ( request.getParameter ( "secondScore" ) );
            testScore.setS_testScore ( secondScore );
            float thirdScore = Float.parseFloat ( request.getParameter ( "thirdScore" ) );
            testScore.setT_testScore ( thirdScore );
            float sum = firstScore + secondScore + thirdScore;
            testScore.setSum ( sum );
            int classification_id = finalScore ( firstScore, secondScore, thirdScore );
            testScore.setClassification_id ( classification_id );
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory ();
            Validator validator = validatorFactory.getValidator ();
            Set<ConstraintViolation<TestScores>> constraintViolations = validator.validate ( testScore );

            if ( !constraintViolations.isEmpty () ) {
                errors = "<div>";
                for (ConstraintViolation<TestScores> constraintViolation : constraintViolations) {
                    errors += "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                            "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                            "<strong>" + constraintViolation.getPropertyPath () + "!</strong>" + " " + constraintViolation.getMessage () + "</div>";
                }
                errors += "</div>";

                request.setAttribute ( "testScore", testScore );
                request.setAttribute ( "errors", errors );
                request.setAttribute ( "firstScore", firstScore );
                request.setAttribute ( "secondScore", secondScore );
                request.setAttribute ( "thirdScore", thirdScore );
                request.setAttribute ( "firstName", firstName );
                request.setAttribute ( "lastName", lastName );

                request.getRequestDispatcher ( "/WEB-INF/admin/student/addScore.jsp" ).include ( request, response );
            } else {
                if ( testScoreDAO.selectByCodeSubid ( student_code, subject_id ) != null ) {
                    flag = false;
                    hashMap.put ( "Oop!", "Student not exists OR Score already exist! Please try choose more subjects" );
                }
                if ( flag ) {
                    testScoreDAO.insertTestScores ( testScore );
                    hashMap.put ( "Done", "Add Student's score success." );
                    TestScores t = new TestScores ();
                    request.setAttribute ( "testScore", t );
                    errors = "<div>";
                    hashMap.forEach ( new BiConsumer<String, String> () {
                        @Override
                        public void accept(String keyError, String valueError) {
                            errors += "<div class=\"alert alert-success alert-dismissible fade show\">\n" +
                                    "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" + "<strong>" + valueError
                                    + "</strong></div>";
                        }
                    } );
                    errors += "</div>";
                    request.setAttribute ( "testScore", testScore );
                    request.setAttribute ( "errors", errors );
                    request.setAttribute ( "firstScore", firstScore );
                    request.setAttribute ( "secondScore", secondScore );
                    request.setAttribute ( "thirdScore", thirdScore );
                    request.setAttribute ( "firstName", firstName );
                    request.setAttribute ( "lastName", lastName );
                    request.getRequestDispatcher ( "/WEB-INF/admin/student/addScore.jsp" ).forward ( request, response );
                } else {
                    errors = "<div>";
                    hashMap.forEach ( new BiConsumer<String, String> () {
                        @Override
                        public void accept(String keyError, String valueError) {
                            errors += "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                    "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" + "<strong>" + valueError
                                    + "!</strong></div>";
                        }
                    } );
                    errors += "</div>";
                    request.setAttribute ( "testScore", testScore );
                    request.setAttribute ( "errors", errors );
                    request.setAttribute ( "firstScore", firstScore );
                    request.setAttribute ( "secondScore", secondScore );
                    request.setAttribute ( "thirdScore", thirdScore );
                    request.setAttribute ( "firstName", firstName );
                    request.setAttribute ( "lastName", lastName );
                    System.out.println ( this.getClass () + " !constraintViolations.isEmpty()" );
                    request.getRequestDispatcher ( "/WEB-INF/admin/student/addScore.jsp" ).include ( request, response );
                }
            }
        } catch (NumberFormatException e) {
            errors = "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                    "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n";
            errors += "<strong>" + "Invalid!"
                    + "!</strong>";

            errors += "</div>";

            request.setAttribute ( "testScore", testScore );
            request.setAttribute ( "errors", errors );
            request.setAttribute ( "firstName", firstName );
            request.setAttribute ( "lastName", lastName );
            request.getRequestDispatcher ( "/WEB-INF/admin/student/addScore.jsp" ).include ( request, response );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
    public int finalScore(float first, float second, float third) {
        int finalScore = 0;
        float check = (first + second + third)/3;
        if ( check >= 0 && check < 5.5 ) {
            finalScore = 4;
        }
        if ( check >= 5.5 && check < 7 ) {
            finalScore = 3;
        }
        if ( check >= 7 && check < 8.5 ) {
            finalScore = 2;
        }
        if ( check >= 8.5 && check <= 10 ) {
            finalScore = 1;
        }
        return finalScore;
    }
    // List Leaderboard Student
    private void listLeaderboardStudents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> allStudentList = studentDAO.selectAllStudent ();
        List<TestScores> leaderboard = testScoreDAO.leaderboard ();
        List<Student> leaderboardStudent = new ArrayList<>();
        for (TestScores score : leaderboard) {
            for (Student student: allStudentList) {
                if ( score.getStudent_code ().equals ( student.getCode () ) ) {
                    leaderboardStudent.add ( student );
                }
            }
        }
//
        request.setAttribute ( "listStudent", leaderboardStudent );
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/student/leaderboard.jsp" );
        dispatcher.forward ( request, response );
    }

    // Show profile
    private void showProfile(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String code = request.getParameter ( "code" );
//        User existingUser = userDAO.selectUser(id);
        Student existingUser = studentDAO.selectStudent ( code );
        request.setAttribute ( "code", existingUser.getCode () );
        request.setAttribute ( "firstName", existingUser.getFirstName () );
        request.setAttribute ( "lastName", existingUser.getLastName () );
        request.setAttribute ( "birthday", existingUser.getDayBirth () );
        request.setAttribute ( "email", existingUser.getEmail () );
        request.setAttribute ( "phoneNum", existingUser.getPhoneNum () );
        request.setAttribute ( "address", existingUser.getAddress () );
        request.setAttribute ( "avatar", existingUser.getAvatar () );
        int classId = existingUser.getClass_id ();
        String className = classDAO.selectClasses ( classId ).getClassName ();
        request.setAttribute ( "classes", className );
        request.setAttribute ( "createDate", existingUser.getCreateDate () );
        request.setAttribute ( "updateDate", existingUser.getUpdateDate () );

        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/student/profile.jsp" );
        dispatcher.forward ( request, response );
    }
}
