package com.zhao.service;

import com.zhao.mapper.PermissionDao;
import com.zhao.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findPermissionsByRoleId(Integer roleId) {
        List<Permission> pers=null;
        try {
          pers = permissionDao.findPermissionsByRoleId(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pers;
    }
}
