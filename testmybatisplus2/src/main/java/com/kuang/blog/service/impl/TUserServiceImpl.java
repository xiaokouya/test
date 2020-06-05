package com.kuang.blog.service.impl;

import com.kuang.blog.pojo.TUser;
import com.kuang.blog.mapper.TUserMapper;
import com.kuang.blog.service.TUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
