package com.kitri.myservletboard.controller;

import com.kitri.myservletboard.data.Member;
import com.kitri.myservletboard.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value="/member/*")
public class MemberController extends HttpServlet {

    MemberService memberService = MemberService.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String command = req.getRequestURI();
        String view = "/view/member/";

        if(command.equals("/member/joinForm")){
            view += "join.jsp";
        }
        else if(command.equals("/member/join")){
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String pw = req.getParameter("password");
            String pwCheck = req.getParameter("password-check");
            String email = req.getParameter("email");

            Member member = new Member(id,name,pw,email);
            member.setPasswordCheck(pwCheck);

            String[] service = memberService.join(member);

            view += service[0];
            String message = service[1];
            req.setAttribute("message",message);
        }
        else if(command.equals("/member/logInForm")){
            view += "login.jsp";
        }
        else if(command.equals("/member/logIn")){
            String id = req.getParameter("id");
            String pw = req.getParameter("password");
            HttpSession session = req.getSession();

            String[] service = memberService.login(id,pw,session);

            view = service[0];
            String message = service[1];
            req.setAttribute("message",message);
        }
        else if(command.equals("/member/logOut")){
            HttpSession session = req.getSession();
            session.invalidate();

            view = "/board/list";
        }
        else if(command.equals("/member/registrationForm")){
            view += "registration.jsp";
        }
        else if(command.equals("/member/registration")){
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String pw = req.getParameter("password");
            String pwCheck = req.getParameter("password-check");
            String email = req.getParameter("email");

            Member member = new Member(id,name,pw,email);
            member.setPasswordCheck(pwCheck);
            HttpSession session = req.getSession();
            String[] service = memberService.registration(member,session);

            view = service[0];
            String message = service[1];
            req.setAttribute("message",message);
        }
        else if(command.equals("/member/info")){
            view += "information.jsp";
        }
        else if(command.equals("/member/delete")){
            String id = req.getParameter("id");
            String delete = req.getParameter("delete");
            if(delete.equals("yes")) {
                HttpSession session = req.getSession();
                session.invalidate();

                memberService.delete(id);
            }
            view = "/board/list";
        }

        req.getRequestDispatcher(view).forward(req,resp);
    }
}
