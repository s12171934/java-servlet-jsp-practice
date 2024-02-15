package com.kitri.myservletboard.data;

public class Pagination {
    private int page;
    private int lastPages;
    private int rows;
    private int pagesInGroup = 5;
    private int startInGroup;
    private int endInGroup;
    private int groupNum;
    public Pagination(int rows){
        this.page = 1;
        this.rows = rows;
    }

    public int getPage() {
        return page;
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
        return this.groupNum == 0;
    }
    public boolean isNext() {
        return this.groupNum == (this.lastPages -1) / this.pagesInGroup;
    }
    public int getLastPages() {
        return lastPages;
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
        calcPageField();
    }

    private void calcPageField(){
        this.groupNum = (this.page - 1) / this.pagesInGroup;
        this.startInGroup = this.groupNum * this.pagesInGroup + 1;
        this.endInGroup = Math.min((this.groupNum + 1) * this.pagesInGroup,this.lastPages);
    }
}
