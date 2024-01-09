package com.programmers.dao;

import com.programmers.data.Data;

import java.util.ArrayList;
import java.util.HashMap;

public interface Dao {
    public HashMap<String, ArrayList<Data>> getAll();
    public void updateNow(int no, String date, String now);
    public void insert(Data data);
}
