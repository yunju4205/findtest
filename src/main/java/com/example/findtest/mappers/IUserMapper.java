package com.example.findtest.mappers;

import com.example.findtest.entities.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserMapper {
    int insertUser(UserEntity userEntity);

    UserEntity selectUser(UserEntity userEntity);

    UserEntity selectFindId(@Param(value = "name")String name,
                            @Param(value = "phoneNumber")String phoneNumber);
    UserEntity selectFindPassword(@Param(value = "email")String email,
                                  @Param(value = "phoneNumber")String phoneNumber);

}
