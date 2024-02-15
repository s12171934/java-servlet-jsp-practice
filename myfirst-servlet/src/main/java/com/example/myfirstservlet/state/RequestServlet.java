package com.example.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestServlet", value = "/state/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String site = req.getParameter("site");
        if(site.equals("naver")){
            resp.sendRedirect("https://www.naver.com");
        } else if(site.equals("google")){
            resp.sendRedirect("https://www.google.com");
        } else if(site.equals("daum")){
            resp.sendRedirect("https://www.daum.net");

        }
    }
}
