package com.example.myfirstservlet.logIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signInFail", value = "/logIn/signInFail")
public class SignInFail extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + req.getAttribute("fail") + "</h1>");
        out.println("<form action=\"/logIn/signIn.html\" method=\"get\">" +
                "<input type=\"submit\" value=\"돌아가기\">" +
                "</form>");
    }
}
