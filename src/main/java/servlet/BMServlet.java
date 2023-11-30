package servlet;

import bookManager.BM;
import bookManager.BookManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/book-manager")
public class BMServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        String feature = req.getParameter("feature");
        ServletContext sc = getServletContext();
        BM bm = (BookManager)sc.getAttribute("BM");

        switch (feature){
            case "addBook":
                bm.addBook(req);
                sc.setAttribute("searchBook",null);
                sc.setAttribute("search","false");
                break;
            case "editBook":
                bm.editBook(req);
                sc.setAttribute("searchBook",null);
                sc.setAttribute("search","false");
                break;
            case "removeBook":
                bm.removeBook(req);
                sc.setAttribute("searchBook",null);
                sc.setAttribute("search","false");
                sc.setAttribute("removeBook","false");
                break;
            case "sort" : bm.sortBook(req);break;
            case "search" :
                sc.setAttribute("searchBook",bm.searchBook(req));
                sc.setAttribute("search","true");
                break;
            case "resetSearch" :
                sc.setAttribute("searchBook",null);
                sc.setAttribute("search","false");
                break;
        }
        sc.setAttribute("BM",bm);
        resp.sendRedirect("/bookManager/bookMain.jsp");
    }
}
