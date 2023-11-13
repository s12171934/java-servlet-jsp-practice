package com.example.myfirstservlet.basic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calc", value = "/basic/calc")
public class Calc extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset = UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body");
        int val1 = Integer.parseInt(request.getParameter("val1"));
        int val2 = Integer.parseInt(request.getParameter("val2"));
        String op = request.getParameter("op");

        out.print("<h1>" + val1 + " " + op + " " + val2 + " = ");

        switch (op) {
            case "+":
                out.print(val1 + val2);
                break;
            case "-":
                out.print(val1 - val2);
                break;
            case "*":
                out.print(val1 * val2);
                break;
            case "/":
                out.print(val1 / (double) val2);
                break;
            case "%":
                out.print(val1 % val2);
                break;
            default:
                out.print("Error");
                break;
        }

        out.println("</h1>");

        out.println("</body></html>");

    }
    public void destroy() {
    }
}
