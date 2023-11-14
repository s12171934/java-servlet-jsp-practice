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

@WebServlet(name = "input", value = "/toDoList/input")
public class Input extends HttpServlet {
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
        if(toDo.isEmpty()){
            out.println("등록된 To-Do List가 없습니다.<br>");
        } else {
            for (String list : toDo) {
                out.print(list);
                out.print("<span style=\"text-align: right\">"+ toDoDate.get(toDo.indexOf(list)) +"</span>");
                out.print("<br>");
            }
        }
        out.println("</p>");
        out.println("</div><div class=\"item\" style=\"max-width: 600px\">");

        if(sc.getAttribute("mode").equals("수정")) {
            out.print("<h2>수정할 To-Do List : ");
            out.println(sc.getAttribute("ch") + "</h2><br>");
        } else{
            out.println("<h2>등록할 To-Do List를 입력해주세요.</h2><br>");
        }

        out.print("<form style=\"text-align: center\" action=\"/toDoList/add\" method=\"get\">" +
                "<input style=\"font-size: 20px; width: 500px\" type=\"text\" name =\"addList\"><br><br>" +
                "<input class=\"submit\" type=\"submit\" value=\"");
        if(sc.getAttribute("mode").equals("수정")){
            out.print("수정");
        } else {
            out.print("등록");
        }
        out.println("\">" + "</form>");
        out.println("</div></div></body>");
    }
}
