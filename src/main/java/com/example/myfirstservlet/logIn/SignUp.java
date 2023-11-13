package com.example.myfirstservlet.logIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
@WebServlet(name = "signUp", value = "/logIn/signUp")
public class SignUp extends HttpServlet {
    protected HashMap<String,User> users = new HashMap<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String s;
        if(users.containsKey(id)){
            s = "/logIn/signUpIdError";
        } else if(!pw.equals(req.getParameter("pwCheck"))) {
            s = "/logIn/signUpPwError";
        } else{
            s = "/logIn/signUpSuccess";
            users.put(id,new User(id,pw));
        }
        resp.sendRedirect(s);
    }
}
