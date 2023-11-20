package com.example.findtest.vos;

import com.example.findtest.entities.UserEntity;

public class LoginVo extends UserEntity {
    private String result;
    public String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result = result;
    }
}
