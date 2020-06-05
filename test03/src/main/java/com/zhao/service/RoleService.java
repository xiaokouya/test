package com.zhao.service;

import com.zhao.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> findRolesByUserUserName(String username);
}
