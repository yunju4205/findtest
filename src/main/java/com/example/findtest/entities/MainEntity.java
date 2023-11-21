package com.example.findtest.entities;

import javax.xml.crypto.Data;

public class MainEntity {
    private int index;
    private String title;
    private String textname;
    private Data textdate;
    private int hits;

    private int userId;



    public MainEntity(){

    }

    public MainEntity(int index, String title, String textname, Data textdate, int hits, int userId) {
        this.index = index;
        this.title = title;
        this.textname = textname;
        this.textdate = textdate;
        this.hits = hits;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextname() {
        return textname;
    }

    public void setTextname(String textname) {
        this.textname = textname;
    }

    public Data getTextdate() {
        return textdate;
    }

    public void setTextdate(Data textdate) {
        this.textdate = textdate;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
