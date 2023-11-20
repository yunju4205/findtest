package com.example.findtest.mappers;

import com.example.findtest.entities.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    int insertUser(UserEntity userEntity);

    UserEntity selectUser(UserEntity userEntity);
}
