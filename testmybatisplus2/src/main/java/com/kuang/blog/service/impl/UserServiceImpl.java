package com.kuang.blog.service.impl;

import com.kuang.blog.pojo.User;
import com.kuang.blog.mapper.UserMapper;
import com.kuang.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author me 赵
 * @since 2020-06-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
