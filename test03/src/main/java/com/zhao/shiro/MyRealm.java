package com.zhao.shiro;

import com.zhao.pojo.Permission;
import com.zhao.pojo.Role;
import com.zhao.pojo.User;
import com.zhao.service.PermissionService;
import com.zhao.service.RoleService;
import com.zhao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    //    获取角色和权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        //username的作用是通过用户名查看该用户扮演的角色
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

//设置该用户所拥有的角色
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
//        roleService.findRolesByUserId(1)
        List<Role> roles = roleService.findRolesByUserUserName(username);
        for (Role role : roles) {
            list.add(role.getRoleName());
            List<Permission> permissions = permissionService.findPermissionsByRoleId(role.getId());
            for (Permission permission : permissions) {
                set.add(permission.getPermissionName());
            }
        }

//        添加该用户所有的角色
        authorizationInfo.addRoles(list);
//        添加该用户所持有的权限
        authorizationInfo.addStringPermissions(set);
        return authorizationInfo;
    }


    //    获取用户名和密码
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.findUserByUsername(username);

        if (user != null) {
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
           //第三个参数应该传的是盐值   第四个参数传的是realm的名字
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), this.getName());
            return authenticationInfo;
        }
        return null;
    }
}
