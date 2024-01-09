package com.kitri.myservletboard.dao;

import com.kitri.myservletboard.data.Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BoardJdbc implements BoardDao{
    private BoardJdbc(){}
    private static BoardJdbc instance = new BoardJdbc();
    public static BoardJdbc getInstance(){return instance;}
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
    public ArrayList<Board> getAll() {
        try {
            String sql = "SELECT * FROM board";
            Statement stmt = conn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Board> boards = new ArrayList<>();
            while (rs.next()){
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String content = rs.getString("content");
                LocalDateTime createAt = rs.getTimestamp("createAt").toLocalDateTime();
                int viewCount = rs.getInt("viewCount");
                int commentCount = rs.getInt("commentCount");
                Board board = new Board(id,title,content,writer,createAt,viewCount,commentCount);
                boards.add(board);
            }
            return boards;

        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Board getById(Long id) {
        return null;
    }

    @Override
    public void save(Board board) {

    }

    @Override
    public void update(Board board) {

    }

    @Override
    public void delete(Board board) {

    }
}
