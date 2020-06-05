package com.zhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello3")
public class Hello3Controller {

    @RequestMapping("/a1")
    public String a1(HttpServletRequest request){
        request.setAttribute("name","张三");
        request.setAttribute("password","abcX123");
        return "b1";
    }

    @RequestMapping("/a2")
    public String a2(String name,String password){
        System.out.println("name "+name);
        System.out.println("password "+password);
        return "hello";
    }

    @RequestMapping("/a3")
    public String a3(){
        return "b2";
    }

    @RequestMapping("/a4")
    public String a4(HttpServletRequest request){
        request.setAttribute("username","小张");
        request.setAttribute("password","123456");
        return "b4";
    }
}
