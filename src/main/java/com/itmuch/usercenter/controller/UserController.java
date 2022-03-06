package com.itmuch.usercenter.controller;


import com.itmuch.usercenter.pojo.User;
import com.itmuch.usercenter.service.IUserService;
import com.itmuch.usercenter.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 分享 前端控制器
 * </p>
 *
 * @author hlc
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @GetMapping("/{id}")
    public User queryUserById(@PathVariable Integer id){

        return this.iUserService.queryUserById(id);

    }
}
