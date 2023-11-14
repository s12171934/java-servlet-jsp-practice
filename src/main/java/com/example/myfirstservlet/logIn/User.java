package com.example.myfirstservlet.logIn;

public class User {
    String id;
    String pw;
    public User(String id, String pw){
        this.id = id;
        this.pw = pw;
    }
    public String getPw() {
        return pw;
    }

}
