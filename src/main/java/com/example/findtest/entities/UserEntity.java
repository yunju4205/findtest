package com.example.findtest.entities;

import java.util.Date;

public class UserEntity {

    private int index;
    private String email;
    private String password;
    private String birth;
    private String phoneNumber;


    public UserEntity (){

    }

    public UserEntity(int index, String email, String password, String birth, String phoneNumber, String name, String date) {
        this.index = index;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.date = date;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    private  String name;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;
}
