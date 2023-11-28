package com.example.findtest.controllers;

import com.example.findtest.entities.UserEntity;
import com.example.findtest.services.UserService;
import com.example.findtest.vos.LoginVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
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
            session.setAttribute("loginVo1", loginVo1);
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

    @GetMapping(value = "/logout")
    public ModelAndView getLogout(ModelAndView modelAndView,
                                  HttpServletRequest request,
                                  HttpSession session){
        session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        modelAndView.setViewName("redirect:/main/postmain");
        return modelAndView;
    }

    @GetMapping(value = "/findid")
    public ModelAndView getFindid (ModelAndView modelAndView){
        modelAndView.setViewName("/user/findId");
        return modelAndView;
    }

    @GetMapping(value = "/findpassword")
    public ModelAndView getFindpassword(ModelAndView modelAndView){
        modelAndView.setViewName("/user/findPassword");
        return modelAndView;
    }
    @GetMapping(value = "/findidmain")
    public ModelAndView getFindidmain(ModelAndView modelAndView,
                                  String name,
                                  String phoneNumber){
        UserEntity userEntity = this.userService.selectFindId(name, phoneNumber);
        modelAndView.addObject("userEntity", userEntity);
        modelAndView.setViewName("/user/findidmain");
        return modelAndView;
    }

    @GetMapping(value = "/findpasswordmain")
    public ModelAndView getFindpasswordmain(ModelAndView modelAndView,
                                        String email,
                                        String phoneNumber){
        UserEntity userEntity = this.userService.selectFindPassword(email, phoneNumber);
        modelAndView.addObject("userEntity", userEntity);
        modelAndView.setViewName("/user/findpasswordmain");
        return modelAndView;
    }



}
