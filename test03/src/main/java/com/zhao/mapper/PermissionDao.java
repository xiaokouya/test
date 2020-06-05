package com.zhao.mapper;

import com.zhao.pojo.Permission;

import java.util.List;

public interface PermissionDao {
    List<Permission> findPermissionsByRoleId(Integer roleId)throws Exception;
}
