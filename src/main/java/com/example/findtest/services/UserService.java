package com.example.findtest.services;

import com.example.findtest.entities.UserEntity;
import com.example.findtest.mappers.IUserMapper;
import com.example.findtest.vos.LoginVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserMapper iUserMapper;

    @Autowired
    public UserService(IUserMapper iUserMapper) {
        this.iUserMapper = iUserMapper;
    }

    public void insertUser(UserEntity userEntity){
        this.iUserMapper.insertUser(userEntity);
    }

    public LoginVo loginUser(LoginVo loginVo){
        UserEntity userEntity = this.iUserMapper.selectUser(loginVo);
        if (userEntity == null){
            loginVo.setResult("실패");
            return loginVo;
        }
        loginVo.setIndex(userEntity.getIndex());
        loginVo.setEmail(userEntity.getEmail());
        loginVo.setPassword(userEntity.getPassword());
        loginVo.setBirth(userEntity.getBirth());
        loginVo.setPhoneNumber(userEntity.getPhoneNumber());
        loginVo.setResult("성공");
        return loginVo;
    }
}
