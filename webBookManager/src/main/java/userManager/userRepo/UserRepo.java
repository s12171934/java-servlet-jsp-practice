package userManager.userRepo;

import userManager.user.User;

import java.util.List;


public interface UserRepo {
    public List<User> getUserList();
    public void addUser(User user);
    public User getUser(String id);
    public void removeUser(String id);
    public void sortUserList(String type,boolean asc);
    public List<User> searchUser(String type, String search);
}
