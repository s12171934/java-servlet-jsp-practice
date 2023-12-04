package servlet;

import bookManager.BM;
import bookManager.BookManager;
import bookManager.book.Book;
import function.RWUser;
import userManager.UM;
import userManager.UserManager;
import userManager.user.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/rent")
public class RMServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        String feature = req.getParameter("feature");
        ServletContext sc = getServletContext();
        BM bm = (BookManager)sc.getAttribute("BM");
        UM um = (UserManager)sc.getAttribute("UM");
        String id = req.getParameter("id");
        User user = um.getUser(id);
        ArrayList<String> checkOutBook = user.getCheckOutBook();
        Book book;

        try{
            switch (feature){
                case "checkOut":
                    String pw = req.getParameter("pw");
                    book = (Book)sc.getAttribute("Book");
                    if(!pw.equals(user.getPw()))break;
                    bm.checkOutBook(req);
                    checkOutBook.add(book.getId());
                    break;
                case "checkIn":
                    book = bm.getBook(req.getParameter("bookId"));
                    sc.setAttribute("Book",book);
                    bm.checkInBook(req);
                    checkOutBook.remove(book.getId());
                    break;
            }

            user.setCheckOutBook(checkOutBook);
            RWUser.writeUser(user);

            sc.setAttribute("BM",bm);
            sc.setAttribute("UM",um);
            resp.sendRedirect("/bookManager/bookMain.jsp");
        } catch (Exception e){
            String errorUrl ="/BM_main.jsp";
            sc.setAttribute("error",errorUrl);
            resp.sendRedirect("/error.jsp");
        }

    }
}