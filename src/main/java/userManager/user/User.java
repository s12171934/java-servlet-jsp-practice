package userManager.user;

public class User {
    private String id;
    private String pw;
    private String name;
    private String sex;
    private String phoneNum;

    public User(String id, String pw, String name, String sex, String phoneNum) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.phoneNum = phoneNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
