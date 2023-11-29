import bookManager.BM;
import bookManager.BookManager;
import function.RW;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

@WebServlet(value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletContext sc = getServletContext();
        BM bm = new BookManager();
        RW.readBooks(bm);
        sc.setAttribute("BM", bm);
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        String page = req.getParameter("page");
        switch (page) {
            case "CheckOut":
                resp.sendRedirect("/checkOut/checkOutMain.jsp");
                break;
            case "BookManager":
                resp.sendRedirect("/bookManager/bookMain.jsp");
                break;
            case "UserManager":
                resp.sendRedirect("/userManager/userMain.jsp");
                break;
        }
    }
}
