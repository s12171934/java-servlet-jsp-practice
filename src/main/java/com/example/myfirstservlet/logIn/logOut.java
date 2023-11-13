package com.example.myfirstservlet.logIn;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

@WebServlet(name = "logOut", value = "/logIn/logOut")
public class logOut extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        ServletContext sc = this.getServletContext();

        Object obj = sc.getAttribute("sessions");
        HashSet<HttpSession> sessions = (HashSet<HttpSession>) obj;
        sessions.remove(session);
        sc.setAttribute("sessions",sessions);


        out.println("<h1>로그아웃 완료!</h1>");
        out.println("<form action=\"/logIn/signIn.html\" method=\"get\">" +
                "<input type=\"submit\" value=\"로그인 화면 돌아가기\">" +
                "</form>");
    }
}
