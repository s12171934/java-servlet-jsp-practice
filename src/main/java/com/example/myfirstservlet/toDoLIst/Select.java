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
        ArrayList<String> toDoDate = (ArrayList<String>)sc.getAttribute("toDoDate");


        out.println("<head><link rel=\"stylesheet\" href=\"toDoList.css\"></head>");
        out.println("<body><div style=\"margin-top: 20px; margin-bottom: 10px\">");


        out.print("<h1>To-Do List</h1><br>");


        out.print("</div><div class=\"wrapper\">");
        out.println("<div class=\"item\" style=\"background-color: white; padding: 15px\"><p>");
        out.print("<form style=\"font-weight: 900; font-size: 40px; margin: 0;\" action=\"/toDoList/del\" method=\"get\">");


        if(toDo.isEmpty()){
            out.println("등록된 To-Do List가 없습니다.<br>");
        } else {
            for (String list : toDo) {
                if(sc.getAttribute("mode").equals("수정")) {
                    out.print("<input type=\"radio\" name=\"toDoList\" value=\"" + list + "\">");
                } else{
                    out.print("<input type=\"checkbox\" name=\"toDoList\" value=\"" + list + "\">");
                }
                out.print(list + "\t");
                out.print("<span style=\"text-align: right\">"+ toDoDate.get(toDo.indexOf(list)) +"</span>");
                out.print("<br>");
            }
        }


        out.println("</p>");
        out.println("</div><div class=\"item\" style=\"max-width: 600px\">");


        out.print("<input class=\"submit\" type=\"submit\" value=\"");
        if(sc.getAttribute("mode").equals("수정")){
            out.print("수정");
        } else {
            out.print("삭제");
        }
        out.println("\">" + "</form>");


        out.println("</div></div></body>");
    }
}
