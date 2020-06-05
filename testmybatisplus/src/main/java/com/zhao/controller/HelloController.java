package com.zhao.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhao.mapper.UserMapper;
import com.zhao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public List<User> hello() {
        QueryWrapper<User> w = new QueryWrapper<>();
        w.ge("age", 17);
        List<User> users = userMapper.selectList(w);
        return users;
    }

    @RequestMapping("/hello2")
    public User hello2() {
        QueryWrapper<User> w = new QueryWrapper<>();
        w.eq("username", "小溪2");
        User user = userMapper.selectOne(w);
        return user;
    }

    @RequestMapping("/hello3")
    public Integer hello3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 17, 35);

        Integer count = userMapper.selectCount(wrapper);
        return count;
    }

    @RequestMapping("/hello4")
    public List<Map<String, Object>> hello4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("username", "池")
                .likeLeft("username", "楠");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
        return maps;
    }

    @RequestMapping("/hello5")
    public List<Object> hello5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select id from user where id<100");

        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
        return objects;
    }

    @RequestMapping("/hello6")
    public List<User> hello6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
        return users;
    }
}
