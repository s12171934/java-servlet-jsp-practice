package com.programmers.controller;

import com.programmers.data.Data;
import com.programmers.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@WebServlet(value = "/one-day-three-quiz/*")
public class Controller extends HttpServlet {
    Service service = Service.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String command = req.getRequestURI().replace("/one-day-three-quiz/","");
        String view = "/programmers.jsp";
        HashMap<String,ArrayList<Data>> datas = service.getDatas();
        req.setAttribute("datas",datas);
        if(command.equals("goDate")){
            String date = req.getParameter("date");

            Set<String> dates = service.getDates();
            if(dates.contains(date)) {
                String url = "/one-day-three-quiz/goDate#" + date;
                resp.sendRedirect(url);
                return;
            }
        }
        if(command.equals("add")){

        }
        if(command.equals("changeNow")){
            String dateNo = req.getParameter("data-date-no");
            String now = req.getParameter("now");
            service.changeNow(dateNo,now);
        }
        req.getRequestDispatcher(view).forward(req,resp);
    }
}
