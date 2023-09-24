package com.yiven.user.controller;

import com.yiven.model.common.dtos.ResponseResult;
import com.yiven.model.user.dtos.UserDto;
import com.yiven.model.user.entity.Role;
import com.yiven.model.user.entity.User;
import com.yiven.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UserController {

    @GetMapping("/login_page")
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = userService.roles();
        modelAndView.addObject("roles",roles);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/register_page")
    public ModelAndView registerPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @Autowired
    private UserService userService;

    @PostMapping("/Login_auth")
    public ResponseResult login(@RequestBody UserDto dto){

        return userService.login(dto);
    }

    @PostMapping("/register_auth")
    public ResponseResult register(@RequestBody User user){

        return userService.register(user);
    }



}
