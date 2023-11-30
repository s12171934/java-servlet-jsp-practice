import bookManager.BM;
import bookManager.BookManager;
import function.RWBook;
import function.RWUser;
import userManager.UM;
import userManager.UserManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletContext sc = getServletContext();

        BM bm = new BookManager();
        UM um = new UserManager();

        RWBook.readBooks(bm);
        RWUser.readUsers(um);

        sc.setAttribute("BM", bm);
        sc.setAttribute("UM",um);
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
