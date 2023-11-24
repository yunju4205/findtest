package com.example.findtest.services;

import com.example.findtest.dtos.MainDto;
import com.example.findtest.entities.MainEntity;
import com.example.findtest.mappers.IMainMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    private final IMainMapper iMainMapper;

    @Autowired
    public MainService(IMainMapper iMainMapper) {
        this.iMainMapper = iMainMapper;
    }
    public MainDto[] showTable(int index){
        return iMainMapper.selectmypage(index);
    }

    public MainDto[] showTable(){
        return iMainMapper.selectMain();
    }

    public void insertMain(MainEntity mainEntity){
        this.iMainMapper.insertMain(mainEntity);
    }

    public MainEntity selectclick(int index) {
        MainEntity mainEntity = this.iMainMapper.selectclick(index);
        this.iMainMapper.updatehits(mainEntity.getHits()+1, index);
        return mainEntity;
    }

    public void updateMain(MainEntity mainEntity){
        this.iMainMapper.updateMain(mainEntity);
    }

    public void deleteMain(int index){this.iMainMapper.deleteMain(index);}
}
