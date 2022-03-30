package com.itmuch.usercenter.controller;


import com.itmuch.usercenter.pojo.User;
import com.itmuch.usercenter.service.IUserService;
import com.itmuch.usercenter.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Resource
    private IUserService iUserService;

    @GetMapping("/{id}")
    public User queryUserById(@PathVariable Integer id){

        log.info("我被请求了");
        return this.iUserService.queryUserById(id);
    }




    /***
     *测试用
    [user]
     * @return {@link User}
     * @throws
     * @author 何林冲  @date 2022/3/30 10:56
     */
    @GetMapping("/q")
    public User query(User user){
        return user;
    }


}
