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
    // Phương thức listCustomers(request, response) nhận về danh sách khách hàng và chuyển sang view customer/list.jsp để hiển thị.
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
    //Phương thức showCreateForm(request, response); sẽ trả về một form được định nghĩa trong view customer/create.jsp:
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "customer/create.jsp" );
        try {
            dispatcher.forward ( request, response );
        }catch (ServletException | IOException e) {
            e.printStackTrace ();
        }
    }
    // Phương thức createCustomer(request, response) sẽ nhận về các tham số được gửi lên từ form, khởi tạo đối tượng Customer
    // và lưu trữ vào trong một danh sách khách hàng giả lập.
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
    //Phương thức showEditForm(request, response) sẽ tìm một khách hàng theo id được truyền vào. Nếu khách hàng không tồn tại thì sẽ hiển thị thông báo lỗi.
    // Nếu khách hàng có tồn tại thì hiển thị thông tin khách hàng lên một view là customer/edit.jsp:
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
    //Phương thức updateCustomer(request, response) sẽ thực hiện thao tác cập nhật thông tin khách hàng
    // vào trong danh sách khách hàng giả lập:
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
    //Phương thức showDeleteForm(request, response):
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
    // Phát triển tính năng xem chi tiết một khách hàng
    //
    //Phương thức viewCustomer(request, response):
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
