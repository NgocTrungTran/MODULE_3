package milo.thuser.controller;

import milo.thuser.dao.CountryDAO;
import milo.thuser.dao.ICountryDAO;
import milo.thuser.dao.UserDAO;
import milo.thuser.model.Country;
import milo.thuser.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.function.BiConsumer;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private ICountryDAO iCountryDAO;
    private String errors = "";

    public void init() {
        userDAO = new UserDAO ();
        iCountryDAO = new CountryDAO ();
        if(this.getServletContext ().getAttribute ( "listCountry" ) == null) {
            this.getServletContext ().setAttribute ( "listCountry", iCountryDAO.selectAllCountry () );
        }
    }

    public UserServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "search":
                    listUserSearch(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "sortasc":
                    listUserSortAsc (request, response);
                    break;
                case "sortdesc":
                    listUserSortDesc (request, response);
                    break;
                case "permision":
                    addUserPermision(request, response);
                    break;
                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;
                case "test-use-tran":
                    testUseTran(request, response);
                    break;
                case "p":
                    listUserPage (request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        dispatcher.forward(request, response);
    }
    private void listUserPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        List<User> listUser = userDAO.selectAllUsers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/displayUsers.jsp");
//        dispatcher.forward(request, response);

        int page = 1;
        int recordsPerPage = 3;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        UserDAO dao = new UserDAO();
        List<User> list = dao.viewAllUsers ((page-1)*recordsPerPage,
                recordsPerPage);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("listUser", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/user/displayUsers.jsp");
        view.forward(request, response);

        request.setAttribute("listUser", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/displayUsers.jsp");
        dispatcher.forward(request, response);
    }
    private void listUserSortAsc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.selectAllUsers();
        List<User> listSortADC = userDAO.sortFullNameADC ( listUser );
        request.setAttribute("listUser", listSortADC);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        dispatcher.forward (request, response);
    }
    private void listUserSortDesc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.selectAllUsers();
        List<User> listSortDESC = userDAO.sortFullNameDEC ( listUser );
        request.setAttribute("listUser", listSortDESC);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        dispatcher.forward (request, response);
    }
    private void listUserSearch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String nameSearch = request.getParameter ( "search" );
        List<User> usersSearch = userDAO.searchNameStudent ( nameSearch );
        for (User user : usersSearch) {
            System.out.println (user);
        }
        request.setAttribute("listUser", usersSearch);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        dispatcher.forward (request, response);
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Country> listCountry = iCountryDAO.selectAllCountry ();
        request.setAttribute ( "listCountry", listCountry );
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = userDAO.selectUser(id);
        User existingUser = userDAO.selectUser ( id );
        request.setAttribute("id", existingUser.getId ());
        request.setAttribute("name", existingUser.getName ());
        request.setAttribute("email", existingUser.getEmail ());

        System.out.println (existingUser.getEmail ());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/edit.jsp");

        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        String name = request.getParameter ( "name" );
//        String email = request.getParameter ( "email" );
//        int idCountry = Integer.parseInt ( request.getParameter ( "idCountry" ) );
//        User newUser = new User ( name, email, idCountry );
//        userDAO.insertUser ( newUser );
//        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/user/create.jsp" );
//        dispatcher.forward ( request, response );
////        response.sendRedirect ( "/users" );
        User user = new User ();
        boolean flag = true;
        Map<String, String> hashMap = new HashMap<String, String>(); // Luu lai truong nao bi loi va loi gi

        System.out.println (this.getClass () + " insertUserValidateFull");
        try {
            user.setId ( Integer.parseInt ( request.getParameter ( "id" ) ) );
            String email = request.getParameter ( "email" );
            user.setEmail ( email );
            user.setName ( request.getParameter ( "name" ) );
            user.setPassword ( request.getParameter ( "password" ) );

            System.out.println ( this.getClass () + " Country value from request: " + request.getParameter ( "country" ) );
            int idCountry = Integer.parseInt ( request.getParameter ( "country" ) );
            user.setCountry ( idCountry );

            System.out.println ( this.getClass () + "User info from request: " + user );

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory ();
            Validator validator = validatorFactory.getValidator ();
            Set<ConstraintViolation<User>> constraintViolations = validator.validate ( user );

            System.out.println ( "User: " + user );
            if ( !constraintViolations.isEmpty () ) {

                errors = "<ul style='list-style: none'>";
                // constraintViolations is has error
                for (ConstraintViolation<User> constraintViolation : constraintViolations) {
                    errors += "<li>" + constraintViolation.getPropertyPath () + " " + constraintViolation.getMessage ()
                            + "</li>";
                }
                errors += "</ul>";


                request.setAttribute ( "user", user );
                request.setAttribute ( "errors", errors );

//                List<Country> listCountry = iCountryDAO.selectAllCountry ();
//                request.setAttribute ( "listCountry", listCountry );

                System.out.println ( this.getClass () + " !constraintViolations.isEmpty()" );
                request.getRequestDispatcher ( "/user/create.jsp" ).forward ( request, response );
            } else {
                if ( userDAO.selectUserByEmail ( email ) != null ) {
                    flag = false;
                    hashMap.put ( "email", "Email exits in database" );
                    System.out.println ( this.getClass () + " Email exits in database" );

                }
                if ( iCountryDAO.selectCountry ( idCountry ) == null ) {
                    flag = false;
                    hashMap.put ( "country", "Country value invalid" );
                    System.out.println ( this.getClass () + " Country invalid" );
                }

                if ( flag ) {
                    // Create user susscess
                    userDAO.insertUserStore ( user );


                    User u = new User ();
                    request.setAttribute ( "user", u );

                    request.getRequestDispatcher ( "user/create.jsp" ).forward ( request, response );
                } else {
                    // Error : Email exits in database
                    // Error: Country invalid
                    errors = "<ul>";
                    // One more field has error
                    hashMap.forEach ( new BiConsumer<String, String> () {
                        @Override
                        public void accept(String keyError, String valueError) {
                            errors += "<li>" + valueError
                                    + "</li>";

                        }
                    } );
                    errors += "</ul>";

                    request.setAttribute ( "user", user );
                    request.setAttribute ( "errors", errors );


                    System.out.println ( this.getClass () + " !constraintViolations.isEmpty()" );
                    request.getRequestDispatcher ( "/user/create.jsp" ).forward ( request, response );
                }
            }
        }catch (NumberFormatException ex) {
            System.out.println(this.getClass() + " NumberFormatException: User info from request: " + user);
            errors = "<ul  style='list-style: none'>";
            errors += "<li>" + "Input format not right"
                    + "</li>";

            errors += "</ul>";


            request.setAttribute("user", user);
            request.setAttribute("errors", errors);

            request.getRequestDispatcher("/user/create.jsp").forward(request, response);
        }
        catch(Exception ex){
            ex.printStackTrace ();
        }
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int idCountry = Integer.parseInt ( request.getParameter("idCountry") );

        User book = new User(id, name, email, idCountry);
        userDAO.updateUser(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);

        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        dispatcher.forward(request, response);
    }
    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {

        User user = new User("quan", "quan.nguyen@codegym.vn", 1);

        int[] permision = {1, 2, 4};

        userDAO.addUserTransaction(user, permision);

    }
    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {

        userDAO.insertUpdateWithoutTransaction();

    }
    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {

        userDAO.insertUpdateUseTransaction();

    }
}
