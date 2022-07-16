package producmanage.btproductmanage.controller;

import producmanage.btproductmanage.model.Product;
import producmanage.btproductmanage.service.IProductService;
import producmanage.btproductmanage.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService ();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter ( "action" );
        if ( action == null ) {
            action = "";
        }
        switch (action) {
            case "add":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter ( "action" );
        if ( action == null ) {
            action = "";
        }
        switch (action) {
            case "add":
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                break;
        }
    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.productService.getAllProduct ();
        request.setAttribute ( "products", productList );
        RequestDispatcher dispatcher = request.getRequestDispatcher ( "product/list.jsp" );
    }
}
