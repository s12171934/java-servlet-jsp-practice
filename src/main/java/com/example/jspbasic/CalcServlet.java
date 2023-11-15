package com.example.jspbasic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calc", value = "/calc")
public class CalcServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        String op = req.getParameter("op");

        out.print(num1 + " " + op + " " + num2 + " = ");
        switch (op){
            case "+" : out.println(num1 + num2);break;
            case "-" : out.println(num1 - num2);break;
            case "*" : out.println(num1 * num2);break;
            case "/" : out.println(num1 / (double)num2);break;
        }


    }
}
