package com.example.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookieServlet", value = "/state/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Cookie cookie1 = new Cookie("id","guest");
        cookie1.setMaxAge(600);
        cookie1.setPath("/");
        resp.addCookie(cookie1);
        Cookie cookie2 = new Cookie("code","007");
        cookie2.setPath("/state/");
        resp.addCookie(cookie2);
        out.println("쿠키전송완료");
    }
}
