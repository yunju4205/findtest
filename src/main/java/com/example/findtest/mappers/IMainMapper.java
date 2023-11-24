package com.example.findtest.mappers;

import com.example.findtest.dtos.MainDto;
import com.example.findtest.entities.MainEntity;
import com.example.findtest.entities.UserEntity;
import com.sun.tools.javac.Main;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMainMapper {

    MainDto[] selectMain();
    MainDto[] selectmypage(@Param(value = "index")int index);

    int insertMain(MainEntity mainEntity);

    MainEntity selectclick(@Param(value = "index") int index);

    int updatehits(@Param(value = "hits") int hits,
                   @Param(value = "index") int index);

    int updateMain(MainEntity mainEntity);

    int deleteMain(@Param(value = "index")int index);
}
