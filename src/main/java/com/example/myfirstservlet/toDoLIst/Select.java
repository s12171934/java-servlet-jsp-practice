package com.example.myfirstservlet.toDoLIst;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "select", value = "/toDoList/select")
public class Select extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        ServletContext sc = this.getServletContext();
        ArrayList<String> toDo = (ArrayList<String>)sc.getAttribute("toDo");

        out.print("<form action=\"/toDoList/del\" method=\"get\">");
        if(toDo.isEmpty()){
            out.println("<h1>등록된 To-Do List가 없습니다.</h1><br>");
        } else {
            out.println("<h1>To-Do List (등록 순)</h1><br><p>");
            for (String list : toDo) {
                out.print("<input type=\"radio\" name=\"toDoList\" value=\"" + list + "\">");
                out.print(list + "<br>");
            }
            out.println("</p>");
        }

        out.print("<input type=\"submit\" value=\"");
        if(sc.getAttribute("mode").equals("수정")){
            out.print("수정");
        } else {
            out.print("삭제");
        }
        out.println("\">" + "</form>");
    }
}
