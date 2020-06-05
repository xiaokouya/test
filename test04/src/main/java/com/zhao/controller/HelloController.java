package com.zhao.controller;

import com.zhao.pojo.Stu;
import com.zhao.pojo.Teacher;
import com.zhao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/hello")
@Controller
public class HelloController {

    @RequestMapping("/hello1")
    public String test(Model model){
         model.addAttribute("msg","你好，明年！");
        return "hello1";
    }

    @RequestMapping("/hello2")
    public String hello2(Model model){
        User user = new User();
        user.setId("1");
        user.setUsername("xiaoming");
        user.setPassword("123456");
        user.setFriend(new User("2","xiaocui","123456"));
        model.addAttribute("user",user);
        return "hello2";
    }

    @RequestMapping("/hello3")
    public String hello3(Model model){
        model.addAttribute("today",new Date());
        model.addAttribute("user",new User("1","xiaoqian","123456",new User("2","xiaomei","123456")));
        model.addAttribute("stu",new Stu("1","小花",17));
        model.addAttribute("teacher",new Teacher("1","小狗"));
        return "hello3";
    }

    @RequestMapping("/hello4")
    public String hello4(Model model, HttpServletRequest request){
        List<Teacher> ts = new ArrayList<>();
        ts.add(new Teacher("1","张老师"));
        ts.add(new Teacher("2","王老师"));
        ts.add(new Teacher("3","寇老师"));
        model.addAttribute("ts",ts);
//        model.addAttribute("stu",new Stu("1","小倩",17));
        request.setAttribute("stu",new Stu("1","小倩",17));
        return "hello4";
    }
}
