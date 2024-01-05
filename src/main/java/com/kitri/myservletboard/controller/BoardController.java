package com.kitri.myservletboard.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/board/*")
public class BoardController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String command = req.getRequestURI();
        String view = "/view/board/";

        if(command.equals("/board/list")){
            view += "list.jsp";
        }
        if(command.equals("/board/createForm")){
            view += "createForm.jsp";
        }
        if(command.equals("/board/create")){

        }
        if(command.equals("/board/updateForm")){
            view += "updateForm.jsp";
        }
        if(command.contains("/board/update/")){

        }
        if(command.contains("/board/delete/")){

        }

        req.getRequestDispatcher(view).forward(req,resp);

    }
}
