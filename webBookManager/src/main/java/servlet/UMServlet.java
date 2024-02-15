package servlet;

import userManager.UM;
import userManager.UserManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user-manager")
public class UMServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        String feature = req.getParameter("feature");
        ServletContext sc = getServletContext();
        UM um = (UserManager)sc.getAttribute("UM");


        try{
            switch (feature){
                case "addUser":
                    um.addUser(req);
                    sc.setAttribute("searchUser",null);
                    sc.setAttribute("search","false");
                    break;
                case "editUser":
                    um.editUser(req);
                    sc.setAttribute("searchUser",null);
                    sc.setAttribute("search","false");
                    break;
                case "changePassWord":
                    um.changePassWord(req);
                    sc.setAttribute("searchUser",null);
                    sc.setAttribute("search","false");
                    break;
                case "removeUser":
                    um.removeUser(req);
                    sc.setAttribute("searchUser",null);
                    sc.setAttribute("search","false");
                    sc.setAttribute("removeUser","false");
                    break;
                case "sort" : um.sortUser(req);break;
                case "search" :
                    sc.setAttribute("searchUser",um.searchUser(req));
                    sc.setAttribute("search","true");
                    break;
                case "resetSearch" :
                    sc.setAttribute("searchUser",null);
                    sc.setAttribute("search","false");
                    break;
            }
            sc.setAttribute("UM",um);
            resp.sendRedirect("/userManager/userMain.jsp");
        } catch (Exception e){
            String errorUrl ="/userManager/userMain.jsp";
            switch (feature) {
                case "addUser": errorUrl = "/userManager/userAdd.jsp"; break;
                case "editUser": errorUrl = "/userManager/userEdit.jsp"; break;
                case "removeUser": errorUrl = "/userManager/userRemove.jsp"; break;
                default: break;
            }
            sc.setAttribute("error",errorUrl);
            resp.sendRedirect("/error.jsp");
        }

    }
}
