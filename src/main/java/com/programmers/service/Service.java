package com.programmers.service;

import com.programmers.dao.Dao;
import com.programmers.dao.DataBase;
import com.programmers.dao.Memory;
import com.programmers.data.Data;

import java.util.ArrayList;
import java.util.HashMap;;
import java.util.Set;


public class Service {
    private Service(){}
    private static Service instance = new Service();
    public static Service getInstance(){return instance;}
    private Dao dao = new DataBase();

    public HashMap<String, ArrayList<Data>> getDatas() {
        return dao.getAll();
    }
    public Set<String> getDates() {
        return dao.getAll().keySet();
    }
    public void changeNow(String dateNo, String now){
        String date = dateNo.split(":")[0];
        int no = Integer.parseInt(dateNo.split(":")[1]);
        ArrayList<Data> dateDatas = dao.getDateData(date);
        for(Data data : dateDatas){
            if(data.getNo() == no){
                data.setNow(now);
            }
        }
    }
}
