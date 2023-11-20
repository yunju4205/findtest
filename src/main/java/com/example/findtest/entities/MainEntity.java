package com.example.findtest.entities;

import javax.xml.crypto.Data;

public class MainEntity {
    private int index;
    private String title;
    private String textname;
    private Data textdate;
    private int hits;

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
