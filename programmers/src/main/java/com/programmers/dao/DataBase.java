package com.programmers.dao;

import com.programmers.data.Data;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class DataBase implements Dao{
    private HashMap<String, ArrayList<Data>> quizDB;

    public Connection conn() throws Exception{

        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:programmers/1234@192.168.10.175:1521:DB19");
        Connection conn = ods.getConnection();
        return conn;
    }
    @Override
    public HashMap<String, ArrayList<Data>> getAll() {
        try{
            quizDB = new HashMap<>();
            String sql = "SELECT * FROM quiz";
            Statement stmt = conn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int no = rs.getInt(1);
                String date = rs.getDate(2).toLocalDate().format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
                String title = rs.getString(3);
                int level = rs.getInt(4);
                String url = rs.getString(5);
                String now = rs.getString(6);
                Data data = new Data(no,date,title,level,url,now);

                ArrayList<Data> datas;
                if(quizDB.containsKey(data.getDate())){
                    datas = quizDB.get(data.getDate());
                } else {
                    datas = new ArrayList<>();
                }
                datas.add(data);
                quizDB.put(data.getDate(),datas);
            }
            rs.close();
            stmt.close();
            conn().close();
        } catch(Exception e){
            ArrayList<Data> data = new ArrayList<>();
            data.add(new Data());
            quizDB.put(LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")),data);
        }
        return quizDB;
    }

    @Override
    public void updateNow(int no, String date, String now) {
        try{
            String sql = "UPDATE quiz SET now =? WHERE no =? AND quiz_date = TO_DATE(?,'YYYY-MM-DD')";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setString(1,now);
            pstmt.setInt(2,no);
            pstmt.setString(3,date);
            int a = pstmt.executeUpdate();
            System.out.println(a);
            conn().commit();

            pstmt.close();
            conn().close();
        } catch (Exception e){}

    }

    @Override
    public void insert(Data data) {
        try{
            String sql = "insert into quiz(no, quiz_date, title, quiz_level, url, now) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn().prepareStatement(sql);
            pstmt.setInt(1,data.getNo());
            pstmt.setDate(2,java.sql.Date.valueOf(data.getDate()));
            pstmt.setString(3, data.getTitle());
            pstmt.setInt(4,data.getLevel());
            pstmt.setString(5,data.getUrl());
            pstmt.setString(6, data.getNow());

            pstmt.executeUpdate();
            conn().commit();
            pstmt.close();
            conn().close();
        } catch (Exception e){}
    }
}
