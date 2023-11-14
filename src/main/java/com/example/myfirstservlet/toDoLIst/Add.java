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

@WebServlet(name = "add", value = "/toDoList/add")
public class Add extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        ServletContext sc = this.getServletContext();
        ArrayList<String> toDo = (ArrayList<String>)sc.getAttribute("toDo");
        if(req.getParameter("addList").isEmpty()){
            RequestDispatcher rd = sc.getRequestDispatcher("/toDoList/input");
            rd.forward(req,resp);
        } else{
            toDo.add(req.getParameter("addList"));
            sc.setAttribute("toDo",toDo);

            RequestDispatcher rd = sc.getRequestDispatcher("/toDoList/main");
            rd.forward(req,resp);
        }

    }
}