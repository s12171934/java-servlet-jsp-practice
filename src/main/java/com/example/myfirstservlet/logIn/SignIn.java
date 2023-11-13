package com.example.myfirstservlet.logIn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "SignIn", value = "/logIn/signIn")
public class SignIn extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String url;
        ServletContext sc = this.getServletContext();
        Object obj = sc.getAttribute("users");
        HashMap<String, User> users = (HashMap<String, User>) obj;

        if(users==null || !users.containsKey(id)){
            req.setAttribute("fail","해당 ID가 존재하지 않습니다.");
            url = "/logIn/signInFail";
        } else if(!users.get(id).getPw().equals(pw)){
            req.setAttribute("fail","올바르지 않은 PW입니다.");
            url = "/logIn/signInFail";
        } else{
            req.setAttribute("id",id);
            url = "/logIn/signInSuccess";
        }
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
