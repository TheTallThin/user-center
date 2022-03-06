package com.itmuch.usercenter.service.impl;

import com.itmuch.usercenter.pojo.User;
import com.itmuch.usercenter.mapper.UserMapper;
import com.itmuch.usercenter.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * <p>
 * 分享 服务实现类
 * </p>
 *
 * @author hlc
 * @since 2022-03-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUserById(Integer id){

        return this.userMapper.selectById(id);


    }


}
