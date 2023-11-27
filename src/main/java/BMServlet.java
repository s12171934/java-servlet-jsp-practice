import bookManager.BM;
import bookManager.BookManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/book-manager")
public class BMServlet extends HttpServlet {
    public static BM bm = new BookManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        String feature = req.getParameter("feature");
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/bookManager/bookMain.jsp");
        switch (feature){
            case "addBook": bm.addBook(req);break;
            case "editBook": bm.editBook(req);break;
            case "removeBook": bm.removeBook(req);break;
            case "sort" : bm.sortBook(req);break;
            case "search" : bm.searchBook(req);break;
        }
        req.setAttribute("BM",bm);
        rd.forward(req,resp);
    }
}
