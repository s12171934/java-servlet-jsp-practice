package com.programmers.data;

import java.util.Date;

public class Data {
    private int no;
    private int level;
    private String date;
    private String title;
    private String url;
    private String now;

    public Data(){}

    public Data(int no, String date, String title, int level, String url, String now){
        this.no = no;
        this.date = date;
        this.title = title;
        this.level = level;
        this.url = url;
        this.now = now;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }
}
