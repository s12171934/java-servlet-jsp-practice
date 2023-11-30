package userManager;

import bookManager.book.Book;
import userManager.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public interface UM {
    public void addUser(HttpServletRequest req);
    public void addUser(String[] userInfo, ArrayList<String> bookInfo);
    public void sortUser(HttpServletRequest req);
    public List<User> searchUser(HttpServletRequest req);
    public void editUser(HttpServletRequest req);
    public void changePassWord(HttpServletRequest req);
    public void removeUser(HttpServletRequest req);
    public void printUser(HttpServletRequest req, HttpServletResponse resp);
    public User getUser(String id);
}
