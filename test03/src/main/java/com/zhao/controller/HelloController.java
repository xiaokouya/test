package com.zhao.controller;

import com.zhao.pojo.Permission;
import com.zhao.pojo.Role;
import com.zhao.service.PermissionService;
import com.zhao.service.RoleService;
import com.zhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/role")
    public List<Role> getRoles(String username){
      return  roleService.findRolesByUserUserName(username);
    }

    @RequestMapping("/permission")
    public List<Permission> getPermissions(Integer roleId){
        return permissionService.findPermissionsByRoleId(roleId);
    }
}
