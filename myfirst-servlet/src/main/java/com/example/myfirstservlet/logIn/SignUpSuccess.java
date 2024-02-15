package com.example.myfirstservlet.logIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signUpSuccess", value = "/logIn/signUpSuccess")
public class SignUpSuccess extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();


        out.println("<head><link rel=\"stylesheet\" href=\"logIn.css\"></head>");
        out.println("<body><div class=\"wrapper\" style=\"display: flex\"><div class=\"item\">");


        out.println("<h1>" + req.getAttribute("id") + "님의 회원가입이<br>성공적으로 완료되었습니다.</h1>");
        out.println("<form action=\"/logIn/signIn.html\" method=\"post\">" +
                "<input style=\"background-color: #29303f; color: #edeff5\" type=\"submit\" value=\"로그인 하러 가기\">" +
                "</form>");


        out.println("</div></div></body>");
    }
}
