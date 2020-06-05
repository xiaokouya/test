package com.zhao.service;

import com.zhao.pojo.User;

public interface UserService {
    User findUserByUsername(String username);
}
