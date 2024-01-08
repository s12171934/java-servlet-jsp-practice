package com.programmers.dao;

import com.programmers.data.Data;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class DataBase implements Dao{
    private HashMap<String, ArrayList<Data>> quizDB;

    public Connection conn() throws Exception{

        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:programmers/1234@192.168.55.3:1521:DB19");
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
    public ArrayList<Data> getDateData(String date) {
        return quizDB.get(date);
    }
}
