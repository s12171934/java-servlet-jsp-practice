import bookManager.BM;
import bookManager.BookManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/book-manager")
public class BMServlet extends HttpServlet {
    BM bm = new BookManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        String feature = req.getParameter("feature");
        switch (feature){
            case "addBook": bm.addBook(req);
            case "editBook": bm.editBook(req);
            case "removeBook": bm.removeBook(req);
            case "sort" : bm.sortBook(req);
            case "search" : bm.searchBook(req);
        }
    }
}
