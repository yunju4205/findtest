package com.example.findtest.services;

import com.example.findtest.entities.UserEntity;
import com.example.findtest.mappers.IUserMapper;
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
}
