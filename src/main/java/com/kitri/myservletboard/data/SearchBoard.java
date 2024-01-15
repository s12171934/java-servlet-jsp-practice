package com.kitri.myservletboard.data;

public class SearchBoard {
    private String period;
    private String type;
    private String searchText;
    private String orderBy;

    public SearchBoard(String period, String type, String searchText, String orderBy) {
        this.period = period;
        this.type = type;
        this.searchText = searchText;
        this.orderBy = orderBy;

        if(this.period == null){
            this.period = "all";
        }
        if(this.type == null){
            this.type = "title";
        }
        if(this.searchText == null){
            this.searchText = "";
        }
    }

    public String getPeriod() {
        return period;
    }
    public String getType() {
        return type;
    }
    public String getSearchText() {
        return searchText;
    }
    public String getOrderBy(){
        return orderBy;
    }
    public String getOrderByQuery(){
        if(orderBy.equals("title")){
            return " ORDER BY (LENGTH(title) - LENGTH('" + searchText + "'))";
        }
        return " ORDER BY " + orderBy;
    }
}
