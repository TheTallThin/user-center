package com.itmuch.usercenter.service;

import com.itmuch.usercenter.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 分享 服务类
 * </p>
 *
 * @author hlc
 * @since 2022-03-06
 */
public interface IUserService extends IService<User> {

    /***
     *根据id查下用户信息
     [id]
     * @return {@link User}
     * @throws
     * @author 何林冲  @date 2022/3/6 22:29
     */
    User queryUserById(Integer id);
}
