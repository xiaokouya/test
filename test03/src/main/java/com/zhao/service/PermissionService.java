package com.zhao.service;

import com.zhao.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findPermissionsByRoleId(Integer roleId);
}
