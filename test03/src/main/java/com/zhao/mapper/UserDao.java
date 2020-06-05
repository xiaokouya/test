package com.zhao.mapper;

import com.zhao.pojo.User;

public interface UserDao {
    User findUserByUsername(String username)throws Exception;
}
