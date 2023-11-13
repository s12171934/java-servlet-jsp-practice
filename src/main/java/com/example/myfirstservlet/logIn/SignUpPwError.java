package com.example.myfirstservlet.logIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signUpPwError", value = "/logIn/signUpPwError")
public class SignUpPwError extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>PW와 PW확인 입력값이 다릅니다.<br> 올바르게 입력해주십시오.</h1>");
        out.println("<form action=\"/logIn/signUp.html\" method=\"get\">" +
                "<input type=\"submit\" value=\"돌아가기\">" +
                "</form>");
    }
}
