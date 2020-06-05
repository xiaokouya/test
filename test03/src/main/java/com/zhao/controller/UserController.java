package com.zhao.controller;

import com.zhao.pojo.User;
import com.zhao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/hello")
    public String hello(){
        return "hello1";
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request){
        Object user = request.getSession().getAttribute("user");
        return "success";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }

    @RequestMapping("/student")
    public String student(HttpServletRequest request){
        return "successs";
    }

    @RequestMapping("/teacher")
    public String teacher(HttpServletRequest request){
        return "success2";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
//        根据用户名密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            request.getSession().setAttribute("user",user);
            return "success";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            request.getSession().setAttribute("user",user);
            request.setAttribute("error","用户名或者密码错误！");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return  "login";
    }

    @ResponseBody
    @RequestMapping("/username")
    public User getUser() throws Exception {
        User xiaohong = userService.findUserByUsername("xiaohong");
        return xiaohong;
    }



}
