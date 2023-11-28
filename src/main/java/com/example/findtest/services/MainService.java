package com.example.findtest.services;

import com.example.findtest.dtos.MainDto;
import com.example.findtest.entities.MainEntity;
import com.example.findtest.mappers.IMainMapper;
import com.example.findtest.vos.UserTableVo;
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

    public UserTableVo showTable(String findSelect, String find, int page){
        UserTableVo userTableVo = new UserTableVo();
        userTableVo.setTableCountPerPage(5);
        userTableVo.setRequestPage(page);
        int minPage = userTableVo.getMinPage();
        int total = this.iMainMapper.findCount(findSelect, find);
        int maxPage = total / userTableVo.getTableCountPerPage() + (total % userTableVo.getTableCountPerPage() == 0 ? 0 : 1);
        final int pageRange = 4;
        int startPage = Math.max(minPage, page - pageRange);
        int endPage = Math.min(maxPage, page + pageRange);
        userTableVo.setMinPage(minPage);
        userTableVo.setMaxPage(maxPage);
        userTableVo.setStartPage(startPage);
        userTableVo.setEndPage(endPage);
        userTableVo.setMainEntities(this.iMainMapper.selectfind(findSelect,find, userTableVo.getTableCountPerPage(), (page - 1) * userTableVo.getTableCountPerPage()));
        return userTableVo;
    }

    public void insertMain(MainEntity mainEntity){
        this.iMainMapper.insertMain(mainEntity);
    }

    public MainEntity selectclick(int index) {
        MainEntity mainEntity = this.iMainMapper.selectclick(index);
        this.iMainMapper.updatehits(mainEntity.getHits()+1, index);
        return mainEntity;
    }

    public MainEntity updateclick(int index){
        MainEntity mainEntity = this.iMainMapper.selectclick(index);
        return mainEntity;
    }

    public void updateMain(MainEntity mainEntity){
        this.iMainMapper.updateMain(mainEntity);
    }

    public void deleteMain(int index){this.iMainMapper.deleteMain(index);}

    public UserTableVo getUser(int page){
        UserTableVo userTableVo = new UserTableVo();
        userTableVo.setTableCountPerPage(5);
        userTableVo.setRequestPage(page);
        int minPage = userTableVo.getMinPage();
        int total = this.iMainMapper.totalCount();
        int maxPage = total / userTableVo.getTableCountPerPage() + (total % userTableVo.getTableCountPerPage() == 0 ? 0 : 1);
        final int pageRange = 4;
        int startPage = Math.max(minPage, page - pageRange);
        int endPage = Math.min(maxPage, page + pageRange);
        userTableVo.setMinPage(minPage);
        userTableVo.setMaxPage(maxPage);
        userTableVo.setStartPage(startPage);
        userTableVo.setEndPage(endPage);
        userTableVo.setMainEntities(this.iMainMapper.selectUserTable(userTableVo.getTableCountPerPage(), (page - 1) * userTableVo.getTableCountPerPage()));
        return userTableVo;
    }
}
