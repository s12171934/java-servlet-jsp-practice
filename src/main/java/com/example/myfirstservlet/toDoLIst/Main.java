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

@WebServlet(name = "main", value = "/toDoList/main")
public class Main extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ArrayList<String> toDo = new ArrayList<>();
        ArrayList<String> toDoDate = new ArrayList<>();
        ServletContext sc = this.getServletContext();
        sc.setAttribute("toDo",toDo);
        sc.setAttribute("toDoDate",toDoDate);
    }

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
                out.print(list + "\t");
                out.print("<span>"+ toDoDate.get(toDo.indexOf(list)) +"</span>");
                out.print("<br>");
            }
        }
        out.println("</p>");
        out.println("</div><div class=\"item\" style=\"max-width: 600px\">");

        out.println("<form action=\"/toDoList/terminal\" method=\"get\">" +
                "<input class=\"submit\" type=\"submit\" name=\"mode\" value=\"추가\">" +
                "</form>");
        out.println("<form action=\"/toDoList/terminal\" method=\"get\">" +
                "<input class=\"submit\" type=\"submit\" name=\"mode\" value=\"수정\">" +
                "</form>");
        out.println("<form action=\"/toDoList/terminal\" method=\"get\">" +
                "<input class=\"submit\" type=\"submit\" name=\"mode\" value=\"삭제\">" +
                "</form>");
        out.println("</div></div></body>");
    }
}
