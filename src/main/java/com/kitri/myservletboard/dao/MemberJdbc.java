package com.kitri.myservletboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MemberJdbc {
    private MemberJdbc(){}
    private static MemberJdbc instance = new MemberJdbc();
    public static MemberJdbc getInstance(){return instance;}
    private Connection conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcurl = "jdbc:mysql://localhost:3306/my_servlet_board";
            String userId = "root";
            String userPass = "1234";
            Connection conn = DriverManager.getConnection(jdbcurl,userId,userPass);
            return conn;
        } catch (Exception e){
            return null;
        }
    }
}
