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

        if(toDo.isEmpty()){
            out.println("<h1>등록된 To-Do List가 없습니다.</h1><br>");
        } else {
            out.print("<h1>To-Do List (등록 순)</h1><br><p>");
            for (String list : toDo) {
                out.print(list + "<br>");
            }
            out.println("</p>");
        }

        if(sc.getAttribute("mode").equals("수정")) {
            out.print("<h4>수정할 To-Do List : ");
            out.println(sc.getAttribute("ch") + "</h4><br>");
        } else{
            out.println("<h4>등록할 To-Do List를 입력해주세요.</h4><br>");
        }

        out.print("<form action=\"/toDoList/add\" method=\"get\">" +
                "<input type=\"text\" name =\"addList\">" +
                "<input type=\"submit\" value=\"");
        if(sc.getAttribute("mode").equals("수정")){
            out.print("수정");
        } else {
            out.print("등록");
        }
        out.println("\">" + "</form>");
    }
}
