package com.kitri.myservletboard.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/member/*")
public class MemberController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String command = req.getRequestURI();
        String view = "/view/member/";

        if(command.equals("/member/joinForm")){
            view += "join.jsp";
        }
        else if(command.equals("/member/join")){
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String pw = req.getParameter("password");
            String pwCheck = req.getParameter("password-check");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            String address2 = req.getParameter("address2");

            view += "";
        }
        else if(command.equals("/member/logInForm")){
            view += "login.jsp";
        }
        else if(command.equals("/member/logIn")){
            String id = req.getParameter("id");
            String pw = req.getParameter("password");

            view += "";
        }
        else if(command.equals("/member/logOut")){

        }
        else if(command.equals("/member/registrationForm")){
            view += "registration.jsp";
        }
        else if(command.equals("/member/registration")){
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String pw = req.getParameter("password");
            String pwCheck = req.getParameter("password-check");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            String address2 = req.getParameter("address2");

        }

        req.getRequestDispatcher(view).forward(req,resp);
    }
}
