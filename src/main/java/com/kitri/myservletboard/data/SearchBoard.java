package com.kitri.myservletboard.data;

public class SearchBoard {
    private String period;
    private String type;
    private String searchText;

    public SearchBoard(String period, String type, String searchText) {
        this.period = period;
        this.type = type;
        this.searchText = searchText;

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
}
