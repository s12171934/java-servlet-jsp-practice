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
        out.println("<head><link rel=\"stylesheet\" href=\"logIn.css\"></head>");
        out.println("<body><div class=\"wrapper\" style=\"display: flex\"><div class=\"item\">");
        out.println("<h1>" + req.getAttribute("fail") + "</h1>");
        out.println("<form action=\"/logIn/signIn.html\" method=\"get\">" +
                "<input style=\"background-color: #29303f; color: #edeff5\" type=\"submit\" value=\"로그인 화면 돌아가기\">" +
                "</form>");
        if(req.getAttribute("sessionError").equals(1)){
            out.println("<form action=\"/logIn/logOut\" method=\"get\">" +
                    "<input type=\"submit\" value=\"로그아웃\">" +
                    "</form>");
        }
        out.println("</div></div></body>");
    }
}
