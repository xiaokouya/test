package com.zhao.mapper;

import com.zhao.pojo.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findRolesByUserUserName(String username)throws Exception;
}
