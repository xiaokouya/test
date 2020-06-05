package com.zhao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhao.mapper.UserMapper;
import com.zhao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getAllUser")
    public List<User> getAllUser() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @RequestMapping("/insert")
    public User testInsertUser() {
        User user = new User();
        user.setUsername("池塘");
        user.setPassword("548963");

        int insert = userMapper.insert(user);
        System.out.println(insert);
        return user;
    }

    @RequestMapping("/update")
    public void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        user.setPassword("111111");

        int i = userMapper.updateById(user);
        System.out.println("受影响的行数：" + i);
    }

    @RequestMapping("/lock")
    public void testOptimisticLocker() {
        User user = userMapper.selectById(2L);
        user.setUsername("竹子");
        user.setPassword("222222");
        userMapper.updateById(user);
    }

    @RequestMapping("/lock2")
    public void testOptimisticLocker2() {
        User user = userMapper.selectById("1268434711468212225");
        user.setUsername("小溪");
        user.setPassword("333333");

        User user2 = userMapper.selectById("1268434711468212225");
        user2.setUsername("小溪2");
        user2.setPassword("333333-2");
        userMapper.updateById(user2);

        //如果没有乐观锁就会覆盖插队线程的值！
        userMapper.updateById(user);
    }

    @RequestMapping("/selectByIds")
    public List<User> testSelectByBatchId() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
        return users;
    }

    @RequestMapping("/selectUserByMap")
    public List<User> testSelectUserByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "池塘");

        List<User> users = userMapper.selectByMap(map);
        return users;
    }

    @RequestMapping("/testPage")
    public void testPage() {
//        当前页，每页的数量
        Page<User> page = new Page<>(2, 2);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    @RequestMapping("/delById")
    public void testDeleteById(){
        userMapper.deleteById(1L);
    }

    @RequestMapping("/selById")
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }
}
