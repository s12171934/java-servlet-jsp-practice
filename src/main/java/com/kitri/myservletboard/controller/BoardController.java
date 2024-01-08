package com.kitri.myservletboard.controller;

import com.kitri.myservletboard.data.Board;
import com.kitri.myservletboard.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(value = "/board/*")
public class BoardController extends HttpServlet {

    BoardService boardService = BoardService.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String command = req.getRequestURI();
        String view = "/view/board/";

        if(command.equals("/board/list")){
            ArrayList<Board> boards = boardService.getBoards();
            req.setAttribute("boards",boards);
            view += "list.jsp";
        }

        else if(command.equals("/board/createForm")){
            view += "createForm.jsp";
        }

        else if(command.equals("/board/create")){
            String title = req.getParameter("title");
            String writer = req.getParameter("writer");
            String content = req.getParameter("contents");
            Board board = new Board(null,title,content,writer,LocalDateTime.now(),0,0);
            boardService.addBoard(board);
            resp.sendRedirect("/board/list");
            return;
        }

        else if(command.equals("/board/updateForm")){
            Long id = Long.parseLong(req.getParameter("id"));
            req.setAttribute("board",boardService.getBoard(id));
            view += "updateForm.jsp";
        }

        else if(command.contains("/board/update")){
            Long id = Long.parseLong(req.getParameter("id"));
            String title = req.getParameter("title");
            String content = req.getParameter("contents");
            Board board = new Board();
            board.setId(id);
            board.setTitle(title);
            board.setContent(content);
            boardService.updateBoard(board);
            resp.sendRedirect("/board/list");
            return;

        }

        else if(command.contains("/board/delete")){
            Long id = Long.parseLong(req.getParameter("id"));
            boardService.deleteBoard(boardService.getBoard(id));
            resp.sendRedirect("/board/list");
            return;

        }

        else if(command.contains("/board/detail")){
            Long id = Long.parseLong(req.getParameter("id"));
            Board board = boardService.getBoard(id);
            req.setAttribute("board",board);
            view += "detail.jsp";
        }

        req.getRequestDispatcher(view).forward(req,resp);

    }
}
