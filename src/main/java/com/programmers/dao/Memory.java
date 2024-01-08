package com.programmers.dao;

import com.programmers.dao.Dao;
import com.programmers.data.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class Memory implements Dao {

    public Memory(){
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("/quiz.txt",StandardCharsets.UTF_8)
            );

            String str;

            while ((str = reader.readLine()) != null) {
                String[] info = str.split("#");
                Data data = new Data();
                data.setDate(info[0]);
                data.setNo(Integer.parseInt(info[1]));
                data.setTitle(info[2]);
                data.setUrl(info[3]);
                data.setLevel(Integer.parseInt(info[4]));
                data.setNow("미확인");

                ArrayList<Data> datas;
                if(memoryDB.containsKey(data.getDate())){
                    datas = memoryDB.get(data.getDate());
                } else {
                    datas = new ArrayList<>();
                }
                datas.add(data);
                memoryDB.put(data.getDate(),datas);
            }

            reader.close();

        } catch (IOException e) {
        }
    }
    private HashMap<String, ArrayList<Data>> memoryDB = new HashMap<>();
    @Override
    public HashMap<String, ArrayList<Data>> getAll() {
        return memoryDB;
    }

    @Override
    public ArrayList<Data> getDateData(String date) {
        return memoryDB.get(date);
    }
}
