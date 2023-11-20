package com.example.findtest.controllers;

import com.example.findtest.entities.UserEntity;
import com.example.findtest.services.UserService;
import com.example.findtest.vos.LoginVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/login")
    public ModelAndView getLogin(ModelAndView modelAndView){
        modelAndView.setViewName("/user/login");
        return modelAndView;
    }

    @PostMapping(value = "/login")
    public ModelAndView postLogin(ModelAndView modelAndView,
                                  LoginVo loginVo,
                                  HttpServletRequest request,
                                  HttpSession session) {
        LoginVo loginVo1 = this.userService.loginUser(loginVo);
        if(loginVo1.getResult().equals("성공")) {
            session = request.getSession();
            session.setAttribute("loginVo1", loginVo);
            modelAndView.setViewName("redirect:/main/postmain");
        } else {
            modelAndView.setViewName("/user/login");
        }
        return modelAndView;
    }

    @GetMapping(value = "/join")
    public ModelAndView getJoin(ModelAndView modelAndView){
        modelAndView.setViewName("/user/join");
        return modelAndView;
    }
    @PostMapping(value = "/join")
    public ModelAndView postJoin(ModelAndView modelAndView,
                                  UserEntity userEntity){
        this.userService.insertUser(userEntity);
        modelAndView.setViewName("redirect:/user/login");
        return modelAndView;
    }


}
