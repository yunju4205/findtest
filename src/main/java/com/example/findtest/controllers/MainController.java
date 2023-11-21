package com.example.findtest.controllers;


import com.example.findtest.entities.MainEntity;
import com.example.findtest.services.MainService;
import com.example.findtest.vos.LoginVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping(value = "index")
    public ModelAndView getIndex(ModelAndView modelAndView,
                                 HttpServletRequest request,
                                 HttpSession session){
        session = request.getSession();
        LoginVo loginVo = (LoginVo) session.getAttribute("loginVo1");
        MainEntity[] mainEntities = this.mainService.showTable(loginVo.getIndex());
        modelAndView.addObject("mainEntities", mainEntities);
        modelAndView.setViewName("/main/postmain");
        return modelAndView;
    }

    @GetMapping(value = "/postmain")
    public ModelAndView getPostmain(ModelAndView modelAndView){
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
                                    MainEntity mainEntity){
        this.mainService.insertMain(mainEntity);
        modelAndView.setViewName("redirect:/main/postmain");
        return modelAndView;
    }

    @GetMapping(value = "/logtext")
    public ModelAndView getLogtext(ModelAndView modelAndView){
        modelAndView.setViewName("/user/logtext");
        return modelAndView;
    }

    @GetMapping(value = "/mypage")
    public ModelAndView getMypage(ModelAndView modelAndView){
        modelAndView.setViewName("/user/mypage");
        return modelAndView;
    }
}
