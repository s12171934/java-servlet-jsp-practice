package com.example.myfirstservlet.toDoLIst;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "terminal", value = "/toDoList/terminal")
public class Terminal extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        ServletContext sc = this.getServletContext();
        String url;

        sc.setAttribute("mode",req.getParameter("mode"));
        if(req.getParameter("mode").equals("추가")){
            url = "/toDoList/input";
        } else{
            ArrayList<String> toDo = (ArrayList<String>)sc.getAttribute("toDo");
            if(toDo.isEmpty()){
                url = "/toDoList/main";
            } else {
                url = "/toDoList/select";
            }
        }

        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}