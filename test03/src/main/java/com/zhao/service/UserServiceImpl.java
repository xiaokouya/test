package com.zhao.service;

import com.zhao.mapper.UserDao;
import com.zhao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User findUserByUsername(String username){
        User user = null;
        try {
           user =  userDao.findUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
