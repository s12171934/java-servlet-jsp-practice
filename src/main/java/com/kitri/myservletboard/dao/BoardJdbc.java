package com.kitri.myservletboard.dao;

import com.kitri.myservletboard.data.Board;

import java.sql.*;
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

            rs.close();
            stmt.close();
            conn().close();

            return boards;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Board getById(Long id) {
        try {
            String sql = "SELECT * FROM board WHERE id = ?";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setLong(1,id);
            ResultSet rs = pstmt.executeQuery();
            Board board = null;
            while (rs.next()){
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String content = rs.getString("content");
                LocalDateTime createAt = rs.getTimestamp("createAt").toLocalDateTime();
                int viewCount = rs.getInt("viewCount");
                int commentCount = rs.getInt("commentCount");
                board = new Board(id,title,content,writer,createAt,viewCount,commentCount);
            }

            rs.close();
            pstmt.close();
            conn().close();

            return board;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public void save(Board board) {
        try {
            String title = board.getTitle();
            String writer = board.getWriter();
            String content = board.getContent();
            String sql = "INSERT INTO board (title,writer,content) VALUES (?,?,?)";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setString(1,title);
            pstmt.setString(2,writer);
            pstmt.setString(3,content);
            pstmt.executeUpdate();
            conn().commit();

            pstmt.close();
            conn().close();

        } catch (Exception e){}
    }

    @Override
    public void update(Board board) {
        try {
            Long id = board.getId();
            String title = board.getTitle();
            String content = board.getContent();
            String sql = "UPDATE board SET title = ?, content = ? WHERE id = ?";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setString(1,title);
            pstmt.setString(2,content);
            pstmt.setLong(3,id);
            pstmt.executeUpdate();
            conn().commit();

            pstmt.close();
            conn().close();

        } catch (Exception e){}

    }

    @Override
    public void delete(Board board) {
        try {
            Long id = board.getId();
            String sql = "DELETE FROM board WHERE id = ?";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setLong(1,id);
            pstmt.executeUpdate();
            conn().commit();

            pstmt.close();
            conn().close();

        } catch (Exception e){}
    }
}
