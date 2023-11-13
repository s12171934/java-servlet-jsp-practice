package com.example.myfirstservlet.logIn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

@WebServlet(name = "SignIn", value = "/logIn/signIn")

public class SignIn extends HttpServlet {
    HashSet<HttpSession> sessions = null;
    @Override
    public void init() throws ServletException {
        ServletContext sc = this.getServletContext();
        sessions = new HashSet<>();
        sc.setAttribute("sessions",sessions);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String url;
        ServletContext sc = this.getServletContext();
        Object obj1 = sc.getAttribute("users");
        Object obj2 = sc.getAttribute("sessions");
        HashMap<String, User> users = (HashMap<String, User>) obj1;
        sessions = (HashSet<HttpSession>) obj2;
        HttpSession session = req.getSession();

        if(users==null || !users.containsKey(id)){
            req.setAttribute("fail","해당 ID가 존재하지 않습니다.");
            url = "/logIn/signInFail";
        } else if(!users.get(id).getPw().equals(pw)){
            req.setAttribute("fail","올바르지 않은 PW입니다.");
            url = "/logIn/signInFail";
        } else if(sessions.contains(session)){
            req.setAttribute("fail","이미 로그인 한 세션입니다. 로그아웃 후 재 로그인 가능합니다.");
            req.setAttribute("sessionError",1);
            url = "/logIn/signInFail";
        } else{
            req.setAttribute("id",id);
            sessions.add(session);
            sc.setAttribute("sessions",sessions);
            url = "/logIn/signInSuccess";
        }
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
