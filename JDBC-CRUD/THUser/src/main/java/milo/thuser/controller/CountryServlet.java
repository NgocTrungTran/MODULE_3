package milo.thuser.controller;


import milo.thuser.dao.CountryDAO;
import milo.thuser.dao.ICountryDAO;
import milo.thuser.model.Country;
import milo.thuser.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CountryServlet", urlPatterns = "/country")
public class CountryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICountryDAO iCountryDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter ( "action" );
        if ( action == null ) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm ( request, response );
                    break;
                case "delete":
                    deleteCountry(request, response);
                    break;
                case "sort":
                    break;
                default:
                    listCountry ( request,response );
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCountry ( request, response );
                    break;
                case "edit":
                    updateCountry ( request, response );
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    public void init() throws ServletException {
        iCountryDAO = new CountryDAO ();
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/country/create.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Country existingCountry = iCountryDAO.selectCountry (id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/country/edit.jsp");
        request.setAttribute("country", existingCountry);
        dispatcher.forward(request, response);
    }
    private void listCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Country> listCountry = iCountryDAO.selectAllCountry ();
        request.setAttribute("listCountry", listCountry);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/country/list.jsp");
        dispatcher.forward(request, response);
    }
    private void insertCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter ( "name" );
        Country newCountry = new Country (name);
        iCountryDAO.insertCountry ( newCountry );
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "/country/create.jsp" );
        dispatcher.forward ( request, response );
    }
    private void updateCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Country book = new Country (id, name);
        iCountryDAO.updateCountry (book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/country/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        iCountryDAO.deleteCountry (id);

        List<Country> listCountry = iCountryDAO.selectAllCountry ();
        request.setAttribute("listCountry", listCountry);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/country/list.jsp");
        dispatcher.forward(request, response);
    }
}
