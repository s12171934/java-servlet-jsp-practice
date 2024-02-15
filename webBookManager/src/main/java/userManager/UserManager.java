package userManager;

import function.RWUser;
import userManager.user.User;
import userManager.userRepo.UserArrayList;
import userManager.userRepo.UserRepo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements UM{

    UserRepo userList = new UserArrayList();
    @Override
    public void addUser(HttpServletRequest req) throws Exception{
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String pwCheck = req.getParameter("pwCheck");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String phoneNum = req.getParameter("phoneNum");

        for(User user : userList.getUserList()){
            if(id.equals(user.getId()))return;
        }
        if(!pw.equals(pwCheck))return;

        User user = new User(id,pw,name,sex,phoneNum);
        userList.addUser(user);
        RWUser.addUser(user);
        RWUser.writeUser(user);
    }

    @Override
    public void addUser(String[] userInfo, ArrayList<String> bookInfo) throws Exception{
        String id = userInfo[0];
        String pw = userInfo[1];
        String name = userInfo[2];
        String sex = userInfo[3];
        String phoneNum = userInfo[4];

        User user = new User(id,pw,name,sex,phoneNum);
        user.setCheckOutBook(bookInfo);
        userList.addUser(user);

    }

    @Override
    public void sortUser(HttpServletRequest req) throws Exception{
        String type = req.getParameter("type");
        boolean asc = Boolean.parseBoolean(req.getParameter("asc"));

        userList.sortUserList(type,asc);
        sortSearchUserList(req,type,asc);
    }

    @Override
    public List<User> searchUser(HttpServletRequest req) throws Exception{
        String type = req.getParameter("type");
        String search = req.getParameter("search");

        return userList.searchUser(type,search);
    }
    public void sortSearchUserList(HttpServletRequest req, String type, boolean asc) throws Exception{
        ServletContext sc = req.getServletContext();

        List<User> userList2 = (List<User>) sc.getAttribute("searchUser");
        int ascInt = asc ? 1 : -1;
        switch (type) {
            case "id":
                userList2.sort((user1, user2) -> Integer.compare(ascInt * user1.getId().compareTo(user2.getId()), 0));
                break;
            case "pw":
                userList2.sort((user1, user2) -> Integer.compare(ascInt * user1.getPw().compareTo(user2.getPw()), 0));
                break;
            case "name":
                userList2.sort((user1, user2) -> Integer.compare(ascInt * user1.getName().compareTo(user2.getName()), 0));
                break;
            case "sex":
                userList2.sort((user1, user2) -> Integer.compare(ascInt * user1.getSex().compareTo(user2.getSex()), 0));
                break;
            case "phoneNum":
                userList2.sort((user1, user2) -> Integer.compare(ascInt * user1.getPhoneNum().compareTo(user2.getPhoneNum()), 0));break;
            default:
                break;
        }
        sc.setAttribute("searchUser",userList2);
    }

    @Override
    public void editUser(HttpServletRequest req) throws Exception{
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String phoneNum = req.getParameter("phoneNum");
        User user = userList.getUser(id);

        if(!pw.equals(user.getPw()))return;

        user.setId(id);
        user.setPw(pw);
        user.setName(name);
        user.setSex(sex);
        user.setPhoneNum(phoneNum);
        RWUser.writeUser(user);
    }

    @Override
    public void changePassWord(HttpServletRequest req) throws Exception{
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String newPw = req.getParameter("newPw");
        String newPwCheck = req.getParameter("newPwCheck");
        User user = userList.getUser(id);

        if(!pw.equals(user.getPw()))return;
        if(!newPw.equals(newPwCheck))return;

        user.setPw(newPw);
        RWUser.writeUser(user);
    }

    @Override
    public void removeUser(HttpServletRequest req) throws Exception{
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        User user = userList.getUser(id);

        if(!pw.equals(user.getPw()))return;

        RWUser.deleteUser(user);
        userList.removeUser(id);
    }

    @Override
    public String printUser(HttpServletRequest req) {
        String data = "";
        List<User> userList1;
        ServletContext sc = req.getServletContext();
        String url = "/userManager/userInfo.jsp";
        boolean remove = false;

        if(sc.getAttribute("removeUser")!=null && sc.getAttribute("removeUser").equals("true")){
            url = "/user-manager";
            remove = true;
        }

        if(sc.getAttribute("search") != null && sc.getAttribute("search").equals("true")){
            userList1 = (List<User>)req.getServletContext().getAttribute("searchBook");
        } else{
            userList1 = userList.getUserList();
        }

        if(userList1.isEmpty()){
            data += "<a>" + " - / - " + "</a><br>";
        } else {
            data += "<form action=\"" + url + "\" method=\"post\">";
            for (User user : userList1) {
                data += "<input type=\""
                        + (remove?"checkbox":"submit")
                        + "\" name=\"" + (remove?"ids":"id")
                        + "\" value=\"" + user.getId() + "\"><a>"
                        + (remove?user.getId() + " / ":"") + user.getName()
                        + "</a><br>";
            }
            if(remove){
                data += "<input type=\"submit\" name=\"feature\" value=\"removeUser\">";
            }
            data += "</form>";
        }
        return data;
    }

    @Override
    public User getUser(String id) {
        return userList.getUser(id);
    }
}
