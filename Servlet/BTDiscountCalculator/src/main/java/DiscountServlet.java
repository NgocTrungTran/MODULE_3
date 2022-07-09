import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String description = request.getParameter ( "Product Description" );
        double listPrice = Double.parseDouble ( request.getParameter ( "List Price" ) ) ;
        double discountPercent = Double.parseDouble ( request.getParameter ( "Discount Percent" ) );
        double discountAmount =  listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;
        PrintWriter writer = response.getWriter ();
        writer.println ("<html>");
        writer.println ("<body>");
        writer.println ("<p>Mô tả của sản phẩm: " + description + "</p>");
        writer.println ("<p>Giá niêm yết của sản phẩm: " + listPrice + "</p>");
        writer.println ("<p>Tỷ lệ chiết khấu (%): " + discountPercent + "</p>");
        writer.println ("<p>Lượng chiết khấu: " + discountAmount + "</p>");
        writer.println ("<p>Giá sau khi đã được chiết khấu: " + discountPrice + "</p>");
        writer.println ("</body>");
        writer.println ("</html>");
    }
}
