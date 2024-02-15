package userManager;

import bookManager.book.Book;
import userManager.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public interface UM {
    public void addUser(HttpServletRequest req) throws Exception;
    public void addUser(String[] userInfo, ArrayList<String> bookInfo) throws Exception;
    public void sortUser(HttpServletRequest req) throws Exception;
    public List<User> searchUser(HttpServletRequest req) throws Exception;
    public void editUser(HttpServletRequest req) throws Exception;
    public void changePassWord(HttpServletRequest req) throws Exception;
    public void removeUser(HttpServletRequest req) throws Exception;
    public String printUser(HttpServletRequest req);
    public User getUser(String id);
}
