package com.kitri.myservletboard.data;

import com.kitri.myservletboard.dao.BoardDao;
import com.kitri.myservletboard.dao.BoardJdbc;

public class Pagination {
    private int page;
    private int lastPages;
    private int rows;
    private int pagesInGroup = 5;
    private int startInGroup;
    private int endInGroup;
    private int groupNum;
    private boolean prev;
    private boolean next;
    public Pagination(int totalRow){
        this.page = 1;
        this.rows = 10;
        this.lastPages = (int)Math.ceil(totalRow/(double)rows);
        calcPageField();
    }

    public int getPage() {
        return page;
    }
    public int getPagesInGroup() {
        return pagesInGroup;
    }

    public int getRows() {
        return rows;
    }

    public int getStartInGroup() {
        return startInGroup;
    }
    public int getEndInGroup() {
        return endInGroup;
    }
    public boolean isPrev() {
        return prev;
    }
    public boolean isNext() {
        return next;
    }
    public void setPage(int page) {
        this.page = page;
        calcPageField();
    }
    public void setRows(int rows) {
        this.rows = rows;
        calcPageField();
    }
    public void setLastPages(int lastPages) {
        this.lastPages = lastPages;
    }
    private void calcPageField(){
        this.groupNum = (this.page - 1) / this.pagesInGroup;
        this.startInGroup = this.groupNum * this.pagesInGroup + 1;
        this.endInGroup = Math.min((this.groupNum + 1) * this.pagesInGroup,this.lastPages);
        if(this.groupNum == 0){
            this.prev = false;
        }else {
            this.prev = true;
        }
        if(this.groupNum == (this.lastPages -1) / this.pagesInGroup){
            this.next = false;
        }else {
            this.next = true;
        }
    }
}
