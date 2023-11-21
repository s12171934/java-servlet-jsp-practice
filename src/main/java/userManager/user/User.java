package userManager.user;

public class User {
    private String userId;
    private String userPw;
    private String userName;
    private String sex;
    private String phoneNum;

    public User(String userId, String userPw, String userName, String sex, String phoneNum) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.sex = sex;
        this.phoneNum = phoneNum;
    }
}
