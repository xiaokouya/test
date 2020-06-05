package com.zhao.controller;

import com.zhao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private User getUser2;

    @Resource
    private User name2;


    @RequestMapping("/user")
    @ResponseBody
    public User getUser(){
        return getUser2;
    }

    @RequestMapping("/user2")
    @ResponseBody
    public User getUser2222(){
        return name2;
    }
}
