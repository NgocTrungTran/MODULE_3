package com.example.btcalcullator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.lang.System.out;

@WebServlet(name = "helloServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        double num1 = Double.parseDouble ( request.getParameter ("fOperand") );
        double num2 = Double.parseDouble ( request.getParameter ("sOperand") );
        String operator = request.getParameter ("operator");
        String result = Calculator.calcultor ( operator,num1,num2 );

        PrintWriter writer = response.getWriter ();
        writer.println ("<html>");
        writer.println ("<body>");
        try {
            writer.println ("<h1>Result: " + result + "</h1>");
        } catch (Exception e) {
            writer.println ("<p>Error: " + e.getMessage () + "</p>");
        }
        writer.println ("</body>");
        writer.println ("</html>");
    }

    public void destroy() {
    }
}