package com.example.findtest.dtos;

import com.example.findtest.entities.MainEntity;

public class MainDto extends MainEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
