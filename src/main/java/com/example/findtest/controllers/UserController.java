package com.example.findtest.controllers;

import com.example.findtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/join")
    public ModelAndView getJoin(ModelAndView modelAndView){
        modelAndView.setViewName("/user/join");
        return modelAndView;
    }
    @GetMapping(value = "/postmain")
    public ModelAndView getPostmain(ModelAndView modelAndView){
        modelAndView.setViewName("/main/postmain");
        return modelAndView;
    }
}
