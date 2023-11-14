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
        ServletContext sc = this.getServletContext();
        sc.setAttribute("toDo",toDo);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        ServletContext sc = this.getServletContext();
        ArrayList<String> toDo = (ArrayList<String>)sc.getAttribute("toDo");

        if(toDo.isEmpty()){
            out.println("<h1>등록된 To-Do List가 없습니다.</h1><br>");
        } else {
            out.print("<h1>To-Do List (등록 순)</h1><br><p>");
            for (String list : toDo) {
                out.print(list + "<br>");
            }
            out.println("</p>");
        }

        out.println("<form action=\"/toDoList/terminal\" method=\"get\">" +
                "<input type=\"submit\" name=\"mode\" value=\"추가\">" +
                "</form>");
        out.println("<form action=\"/toDoList/terminal\" method=\"get\">" +
                "<input type=\"submit\" name=\"mode\" value=\"수정\">" +
                "</form>");
        out.println("<form action=\"/toDoList/terminal\" method=\"get\">" +
                "<input type=\"submit\" name=\"mode\" value=\"삭제\">" +
                "</form>");
    }
}
