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
@WebServlet(name = "signUp", value = "/logIn/signUp")
public class SignUp extends HttpServlet {
    private HashMap<String,User> users = new HashMap<>();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String url;
        ServletContext sc = this.getServletContext();
        if(req.getParameter("id").isEmpty() || req.getParameter("pw").isEmpty() || req.getParameter("pwCheck").isEmpty()){
            resp.sendRedirect("/logIn/signUp.html");
        } else {
            if (users.containsKey(id)) {
                req.setAttribute("error", "이미 존재하는 회원입니다.");
                url = "/logIn/signUpError";
            } else if (!pw.equals(req.getParameter("pwCheck"))) {
                req.setAttribute("error", "비밀번호가 일치하지 않습니다");
                url = "/logIn/signUpError";
            } else {
                req.setAttribute("id", id);
                url = "/logIn/signUpSuccess";
                users.put(id, new User(id, pw));
                sc.setAttribute("users", users);
            }
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(req, resp);
        }
    }
}
