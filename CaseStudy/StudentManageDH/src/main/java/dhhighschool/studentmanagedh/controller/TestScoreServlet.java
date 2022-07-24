package dhhighschool.studentmanagedh.controller;

import dhhighschool.studentmanagedh.dao.*;
import dhhighschool.studentmanagedh.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TestScoreServlet", urlPatterns = "/scores")
public class TestScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String errors = "";
    private IStudentDAO studentDAO;
    private ISubjectDAO subjectDAO;
    private ITestScoreDAO testScoreDAO;
    private IClassDAO classDAO;


    public void init() {
        testScoreDAO = new TestScoreDAO ();
        studentDAO = new StudentDAO ();
        subjectDAO = new SubjectDAO ();
        classDAO = new ClassDAO ();
        if ( this.getServletContext ().getAttribute ( "listSubjects" ) == null ) {
            this.getServletContext ().setAttribute ( "listSubjects", subjectDAO.selectAllSubjectDAO () );
        }
        if ( this.getServletContext ().getAttribute ( "listClass" ) == null ) {
            this.getServletContext ().setAttribute ( "listClass", classDAO.selectAllClass () );
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
                    showAddScoreForm ( request, response );
                    break;
                case "update":
                    break;
                case "remove":
                    break;
                default:
//                    homePage ( request, response );
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException ( ex );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType ( "text/html;charset=UTF-8" );
//        request.setCharacterEncoding ( "utf-8" );
//        String action = request.getParameter ( "action" );
//        if ( action == null ) {
//            action = "";
//        }
//
//        try {
//            switch (action) {
//                case "add":
////                    insertStudent ( request, response );
//                    break;
//                case "update":
//                    break;
//                default:
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException ( ex );
//        }
    }
    private void showAddScoreForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String code = request.getParameter ( "code" );
//        User existingUser = userDAO.selectUser(id);
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

        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/WEB-INF/admin/score/addScore.jsp" );

        dispatcher.forward ( request, response );
    }
}
