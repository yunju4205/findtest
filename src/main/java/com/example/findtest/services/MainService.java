package com.example.findtest.services;

import com.example.findtest.entities.MainEntity;
import com.example.findtest.mappers.IMainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    private final IMainMapper iMainMapper;

    @Autowired
    public MainService(IMainMapper iMainMapper) {
        this.iMainMapper = iMainMapper;
    }

    public MainEntity[] showTable(int index){
        return iMainMapper.selectUser(index);
    }
}
