package com.example.myfirstservlet.state;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "stateStoreServlet", value = "/state/store")
public class StateStoreServlet extends HttpServlet {
    int memberCount = 0;
    ServletContext servletContext = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        servletContext = config.getServletContext();
        servletContext.setAttribute("count",0);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int localCount = 0;
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        int applicationCount = (int)servletContext.getAttribute("count");
        out.println("전역 변수 카운트: " + ++memberCount);
        out.println("지역 변수 카운트: " + ++localCount);
        out.println("ServletContext 카운트: " + ++applicationCount);

        servletContext.setAttribute("count",applicationCount);
        Integer count = (Integer) session.getAttribute("count");
        if(count == null){
            count = 0;
            session.setAttribute("count",count);
        }
        session.setAttribute("count",++count);
        out.println("세션 카운트 :"+ count);
    }
}
