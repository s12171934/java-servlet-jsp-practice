package com.kitri.myservletboard.dao;

import com.kitri.myservletboard.data.Board;
import com.kitri.myservletboard.data.Pagination;
import com.kitri.myservletboard.data.SearchBoard;

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
    public ArrayList<Board> getAll(Pagination pagination, SearchBoard searchBoard) {
        try {
            int page = pagination.getPage();
            int rows = pagination.getRows();
            String period = searchBoard.getPeriod();
            String type = searchBoard.getType();
            String searchText = searchBoard.getSearchText();
            String orderByQuery = searchBoard.getOrderByQuery();
            pagination.setLastPages((int)Math.ceil((double)getRowNum(searchBoard)/rows));
            String sql ="";
            if(type.equals("title")){
                searchText = "%" + searchText + "%";
            }
            sql = "SELECT * FROM board  WHERE " + type + " LIKE ? " + dateQuery(period) + orderByQuery + " LIMIT ?, ?";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setString(1,searchText);
            pstmt.setInt(2,(page - 1) * rows);
            pstmt.setInt(3,rows);
            ResultSet rs = pstmt.executeQuery();
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
            pstmt.close();
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

    @Override
    public int getRowNum(SearchBoard searchBoard) {
        int rownum = 0;
        String period = searchBoard.getPeriod();
        String type = searchBoard.getType();
        String searchText = searchBoard.getSearchText();
        try {
            String sql ="";
            if(type.equals("title")){

                searchText = "%" + searchText + "%";
            }
            sql = "SELECT COUNT(*) FROM board  WHERE " + type + " LIKE ? " + dateQuery(period);
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setString(1,searchText);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                rownum = rs.getInt(1);
            }

            rs.close();
            pstmt.close();
            conn().close();

        } catch (Exception e){}
        return rownum;
    }
    private String dateQuery(String period){
        if(period.equals("all")){
            return "";
        }
        String date = "";
        switch (period){
            case "day" :
                date = "1 DAY";
                break;
            case "week" :
                date = "7 DAY";
                break;
            case "month" :
                date = "1 MONTH";
                break;
            case "half" :
                date = "6 MONTH";
                break;
            case "year" :
                date = "1 YEAR";
                break;
        }
        return "AND createAt > DATE_SUB(SYSDATE(), INTERVAL " + date + ")";
    }
}
