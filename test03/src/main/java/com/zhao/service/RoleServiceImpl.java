package com.zhao.service;

import com.zhao.mapper.RoleDao;
import com.zhao.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Role> findRolesByUserUserName(String username){
        List<Role> roles=null;
        try {
          roles = roleDao.findRolesByUserUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }
}
