package com.zhao.controller;

import com.zhao.pojo.User2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/hello2")
public class Hello2Controller {

    @RequestMapping("/a1")
    public String a1(HttpServletRequest request) {
        request.setAttribute("username", "小张");
        return "a1";
    }


    @RequestMapping("/a2")
    @ResponseBody
    public User2 getUser2(User2 user) {
        return user;
    }

    @RequestMapping("/a3")
    public String a3() {
        return "a2";
    }

    @RequestMapping("/a4")
    public String a4(HttpServletRequest request) {
        List<String> list = new ArrayList<>();
        list.add("小明");
        list.add("小花");
        list.add("明年");
        list.add("你好");
        list.add("期待");
        request.setAttribute("list", list);
        return "a4";
    }

    @RequestMapping("/a5")
    public String a5(HttpServletRequest request) {
        request.setAttribute("uid", "1234567890");
        request.setAttribute("name", "<span style='color:red'>Jerry</span>");
        return "a5";
    }

    @RequestMapping("/a6")
    public String a6(HttpServletRequest request) {
        request.setAttribute("user", new User2("1", "xiaoming", "123456"));
        return "a5";
    }

    @RequestMapping("/a7")
    public String a7(HttpServletRequest request) {
        Set<String> names = new HashSet<>();
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            names.add("boot-" + i);
            ids.add(i);
        }
        request.setAttribute("names", names);
        request.setAttribute("ids", ids);
        request.setAttribute("mydate", new Date());
        return "a6";
    }

    @RequestMapping("/a8")
    public String a8(HttpServletRequest request, Model model) {
        request.setAttribute("req", "springboot-request");
        request.getSession().setAttribute("sess", "springboot-session");
        request.getServletContext().setAttribute("app", "springboot-application");
        model.addAttribute("url", "www.baidu.com");
        request.setAttribute("url2", "<span style='color:red'>www.baidu.com</span>");
        return "a8";
    }

    @RequestMapping("/a9")
    public String a9(HttpServletRequest request){
        request.setAttribute("name","xiaozhang");
        request.setAttribute("age",17);
        return "a9";
    }

    @RequestMapping("/a10")
    public String a10(HttpServletRequest request){
        List<User2> list = new ArrayList<>();
        list.add(new User2("1","次啊","123456"));
        list.add(new User2("2","小张","123456"));
        list.add(new User2("3","小云","654321"));
        request.setAttribute("list",list);

        Map<String,User2> map = new HashMap<>();
        map.put("key1",new User2("1","小花","123456"));
        map.put("key2",new User2("2","花葵","555"));
        map.put("key3",new User2("3","小明","456852"));
        request.setAttribute("map",map);
        return "a10";
    }
}
