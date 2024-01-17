package com.kitri.myservletboard.dao;

import com.kitri.myservletboard.data.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberJdbc implements MemberDao {
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

    @Override
    public Member getMember(String id) {
        Member member = null;
        try{
            String sql = "SELECT * FROM member WHERE memberId = ?";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String pw = rs.getString("password");
                String name = rs.getString("memberName");
                String email = rs.getString("email");
                long serialId = rs.getInt("id");
                member = new Member(id,name,pw,email);
                member.setSerialId(serialId);
            }
        } catch (Exception e){
        }
        return member;
    }

    @Override
    public void addMember(Member member) {
        try {

            String sql = "INSERT INTO member (memberId,password,memberName,email) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getEmail());
            pstmt.executeUpdate();
            conn().commit();

            pstmt.close();
            conn().close();

        } catch (Exception e){}

    }

    @Override
    public void updateMember(Member member) {
        try {
            String sql = "UPDATE member SET password = ?, memberName = ?, email = ? WHERE memberId = ?";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setString(1, member.getPassword());
            pstmt.setString(2, member.getName());
            pstmt.setString(3,member.getEmail());
            pstmt.setString(4,member.getId());
            pstmt.executeUpdate();
            conn().commit();

            pstmt.close();
            conn().close();

        } catch (Exception e){}
    }

    @Override
    public void deleteMember(String id) {
        try {
            String sql = "DELETE FROM member WHERE memberId = ?";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
            conn().commit();

            pstmt.close();
            conn().close();

        } catch (Exception e){}
    }
}
