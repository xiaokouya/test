package com.zhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return "hello2";
    }

    @RequestMapping("/hello3")
    public String  hello3(){
        return "hello3";
    }

    @RequestMapping("/hello4")
    public String hello4(){
        return "hello4";
    }

    @RequestMapping("/hello5")
    public String hello5(){
        return "hello5";
    }

    @RequestMapping("/hello6")
    public String hello6(){
        return "hello6";
    }

    @RequestMapping("/hello7")
    public String hello7(){
        return "hello7";
    }

    @RequestMapping("/hello8")
    public String hello8(){
        return "hello8";
    }

    @RequestMapping("/hello9")
    public String hello9(){
        return "hello9";
    }
}
