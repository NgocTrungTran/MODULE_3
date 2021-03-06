package com.codegym.thquanlykhachhang.controller;

import com.codegym.thquanlykhachhang.model.Customer;
import com.codegym.thquanlykhachhang.services.CustomerService;
import com.codegym.thquanlykhachhang.services.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerSevlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private final CustomerService customerServlet = new CustomerServiceImpl ();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter ( "action" );
        if ( action == null ) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer ( request, response );
                break;
            case "edit":
                updateCustomer ( request, response );
                break;
            case "delete":
                deleteCustomer ( request, response );
                break;
            default:
                listCustomers ( request, response );
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter ( "action" );
        if ( action == null ) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm ( request, response );
                break;
            case "edit":
                showEditForm ( request, response );
                break;
            case "delete":
                showDeleteForm ( request, response );
                break;
            case "view":
                viewCustomer ( request, response );
                break;
            default:
                listCustomers ( request, response );
                break;
        }
    }
    // Ph????ng th???c listCustomers(request, response) nh???n v??? danh s??ch kh??ch h??ng v?? chuy???n sang view customer/list.jsp ????? hi???n th???.
    private void listCustomers(HttpServletRequest request, HttpServletResponse response){
        List<Customer> customers = this.customerServlet.findAll ();
        request.setAttribute ( "customers", customers );

        RequestDispatcher dispatcher = request.getRequestDispatcher ( "customer/list.jsp" );

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    //Ph????ng th???c showCreateForm(request, response); s??? tr??? v??? m???t form ???????c ?????nh ngh??a trong view customer/create.jsp:
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "customer/create.jsp" );
        try {
            dispatcher.forward ( request, response );
        }catch (ServletException | IOException e) {
            e.printStackTrace ();
        }
    }
    // Ph????ng th???c createCustomer(request, response) s??? nh???n v??? c??c tham s??? ???????c g???i l??n t??? form, kh???i t???o ?????i t?????ng Customer
    // v?? l??u tr??? v??o trong m???t danh s??ch kh??ch h??ng gi??? l???p.
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter ( "name" );
        String email = request.getParameter("email");
        String address = request.getParameter ( "address" );
        int id = (int) (Math.random () * 10000);

        Customer customer = new Customer (id, name, email, address);
        this.customerServlet.save ( customer );
        RequestDispatcher dispatcher = request.getRequestDispatcher ( ("customer/create.jsp") );
        request.setAttribute ( "message", "New customer war created" );
        try {
            dispatcher.forward ( request, response );
        }catch (ServletException | IOException e) {
            e.printStackTrace ();
        }
    }
    //Ph????ng th???c showEditForm(request, response) s??? t??m m???t kh??ch h??ng theo id ???????c truy???n v??o. N???u kh??ch h??ng kh??ng t???n t???i th?? s??? hi???n th??? th??ng b??o l???i.
    // N???u kh??ch h??ng c?? t???n t???i th?? hi???n th??? th??ng tin kh??ch h??ng l??n m???t view l?? customer/edit.jsp:
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt ( request.getParameter ( "id" ) );
        Customer customer = this.customerServlet.findById ( id );
        RequestDispatcher dispatcher;
        if ( customer == null ) {
            dispatcher = request.getRequestDispatcher ( "error-404.jsp" );
        }else {
//            System.out.println ("Customer: " + customer);
            request.setAttribute ( "customer", customer );
            dispatcher = request.getRequestDispatcher ( "customer/edit.jsp" );
        }
        try {
            dispatcher.forward ( request,response );
        }catch (ServletException | IOException e) {
            e.printStackTrace ();
        }
    }
    //Ph????ng th???c updateCustomer(request, response) s??? th???c hi???n thao t??c c???p nh???t th??ng tin kh??ch h??ng
    // v??o trong danh s??ch kh??ch h??ng gi??? l???p:
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt ( request.getParameter ( "id" ) );
        String name = request.getParameter ( "name" );
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = this.customerServlet.findById ( id );
        RequestDispatcher dispatcher;
        if ( customer == null ) {
            dispatcher = request.getRequestDispatcher ("error-404.jsp");
        }else {
            customer.setName ( name );
            customer.setEmail ( email );
            customer.setAddress ( address );
            this.customerServlet.update ( id, customer );
            request.setAttribute ( "customer", customer );
            request.setAttribute ( "message", "Customer information was update" );
            dispatcher = request.getRequestDispatcher ("customer/edit.jsp");
        }
        try{
            dispatcher.forward ( request, response );
        }catch (ServletException | IOException e) {
            e.printStackTrace ();
        }
    }
    //Ph????ng th???c showDeleteForm(request, response):
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt ( request.getParameter ( "id" ) );
        Customer customer = this.customerServlet.findById ( id );
        RequestDispatcher dispatcher;
        if ( customer == null ) {
            dispatcher = request.getRequestDispatcher ("error-404.jsp");
        }else {
            request.setAttribute ( "customer", customer );
            dispatcher = request.getRequestDispatcher ( "customer/delete.jsp" );
        }
        try {
            dispatcher.forward ( request, response );
        }catch (ServletException | IOException e) {
            e.printStackTrace ();
        }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt ( request.getParameter ( "id" ) );
        Customer customer = this.customerServlet.findById ( id );
        RequestDispatcher dispatcher;
        if ( customer == null ){
            dispatcher = request.getRequestDispatcher ( "error-404.jsp" );
        }else {
            this.customerServlet.remove ( id );
            try {
                response.sendRedirect ( "/customers" );
            }catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }
    // Ph??t tri???n t??nh n??ng xem chi ti???t m???t kh??ch h??ng
    //
    //Ph????ng th???c viewCustomer(request, response):
    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt ( request.getParameter ( "id" ) );
        Customer customer = this.customerServlet.findById ( id );
        RequestDispatcher dispatcher;
        if ( customer == null ) {
            dispatcher = request.getRequestDispatcher ("error-404.jsp");
        } else {
            request.setAttribute ( "customer", customer );
            dispatcher = request.getRequestDispatcher ( "customer/view.jsp" );
        }
        try {
            dispatcher.forward ( request, response );
        }catch (ServletException e) {
            e.printStackTrace ();
        }catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
