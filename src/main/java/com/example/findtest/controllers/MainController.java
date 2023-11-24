package com.example.findtest.controllers;


import com.example.findtest.dtos.MainDto;
import com.example.findtest.entities.MainEntity;
import com.example.findtest.services.MainService;
import com.example.findtest.vos.LoginVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.juli.logging.Log;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "main")
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping(value = "postmain")
    public ModelAndView getPostmain(ModelAndView modelAndView){
        MainDto[] mainDtos = this.mainService.showTable();
        modelAndView.addObject("mainDtos", mainDtos);
        modelAndView.setViewName("/main/postmain");
        return modelAndView;
    }

    @GetMapping(value = "/textadd")
    public ModelAndView getTextadd(ModelAndView modelAndView){
        modelAndView.setViewName("/user/textadd");
        return modelAndView;
    }
    @PostMapping(value = "textadd")
    public ModelAndView postTextadd(ModelAndView modelAndView,
                                    MainEntity mainEntity,
                                    HttpServletRequest request,
                                    HttpSession session){
        session = request.getSession();
        LoginVo loginVo = (LoginVo) session.getAttribute("loginVo1");
        mainEntity.setUserId(loginVo.getIndex());
        this.mainService.insertMain(mainEntity);
        modelAndView.setViewName("redirect:/main/postmain");
        return modelAndView;
    }



    @GetMapping(value = "/mypage")
    public ModelAndView getMypage(ModelAndView modelAndView,
                                  HttpServletRequest request,
                                  HttpSession session){
        session = request.getSession();
        LoginVo loginVo = (LoginVo) session.getAttribute("loginVo1");
        MainDto[] mainDtos = this.mainService.showTable(loginVo.getIndex());
        modelAndView.addObject("mainDtos", mainDtos);
        modelAndView.setViewName("/user/mypage");
        return modelAndView;
    }


    @GetMapping(value = "/textclick")
    public ModelAndView getTextclick(ModelAndView modelAndView,
                                     int index){
        MainEntity mainEntity = this.mainService.selectclick(index);
        modelAndView.addObject("mainEntity", mainEntity);
        modelAndView.setViewName("/user/textclick");
        return modelAndView;
    }

    @GetMapping(value = "/logtext")
    public ModelAndView getLogtext(ModelAndView modelAndView,
                                   int index){
        MainEntity mainEntity = this.mainService.updateclick(index);
        modelAndView.addObject("mainEntity", mainEntity);
        modelAndView.setViewName("/user/logtext");
        return modelAndView;
    }

    @PostMapping(value = "/logtext")
    public ModelAndView postLogtext(ModelAndView modelAndView,
                                    MainEntity mainEntity){
        this.mainService.updateMain(mainEntity);
        modelAndView.setViewName("redirect:/main/mypage");
        return modelAndView;
    }

    @GetMapping(value = "/delete")
    public ModelAndView getDelete(ModelAndView modelAndView,
                                  int index){
        this.mainService.deleteMain(index);
        modelAndView.setViewName("redirect:/main/mypage");
        System.out.println(index);
        return modelAndView;
    }

    @GetMapping(value = "/find")
    public ModelAndView getFind(ModelAndView modelAndView,
                                String findSelect,
                                String find){
        MainDto[] mainDtos = this.mainService.showTable(findSelect, find);
        modelAndView.addObject("mainDtos", mainDtos);
        modelAndView.setViewName("/main/postmain");
        return modelAndView;
    }

}
