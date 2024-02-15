package com.example.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "userVisit",value ="/state/userVisit")
public class UserVisitServlet extends HttpServlet {
    HashMap<HttpSession,User> users = new HashMap<>();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        if(!users.containsKey(session)){
            User user = new User();
            user.setName(req.getParameter("name"));
            user.setCity(req.getParameter("city"));
            user.setCount(0);
            users.put(session,user);
        }

        users.get(session).setCount(users.get(session).getCount() + 1);

        users.forEach((key,value) -> {
            out.println(value);
        });
    }
}
