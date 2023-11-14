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

        out.println("<head><link rel=\"stylesheet\" href=\"logIn.css\"></head>");
        out.println("<body><div class=\"wrapper\" style=\"display: flex\"><div class=\"item\">");
        if(sessions == null || sessions.isEmpty()){
            out.println("<h1>로그인 상태가 아닙니다.</h1>");
        } else{
            sessions.remove(session);
            sc.setAttribute("sessions",sessions);
            out.println("<h1>로그아웃 완료!</h1>");
        }
        out.println("<form action=\"/logIn/signIn.html\" method=\"get\">" +
                "<input style=\"background-color: #29303f; color: #edeff5\" type=\"submit\" value=\"로그인 화면 돌아가기\">" +
                "</form>");
        out.println("</div></div></body>");
    }
}
