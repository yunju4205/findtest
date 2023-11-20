package com.example.findtest.mappers;

import com.example.findtest.entities.MainEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMainMapper {
    MainEntity[] selectUser(@Param(value = "index")int index);
}
