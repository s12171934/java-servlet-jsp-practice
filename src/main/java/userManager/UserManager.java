package userManager;

import userManager.user.User;
import userManager.userRepo.UserArrayList;
import userManager.userRepo.UserRepo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserManager implements UM{

    UserRepo userList = new UserArrayList();
    @Override
    public void addUser(HttpServletRequest req) {

    }

    @Override
    public void addUser(String[] userInfo) {

    }

    @Override
    public void sortUser(HttpServletRequest req) {

    }

    @Override
    public List<User> searchUser(HttpServletRequest req) {
        return null;
    }

    @Override
    public void editUser(HttpServletRequest req) {

    }

    @Override
    public void removeUser(HttpServletRequest req) {

    }

    @Override
    public void printUser(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public User getUser(String id) {
        return null;
    }
}
