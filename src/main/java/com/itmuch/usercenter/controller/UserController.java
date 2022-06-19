package com.itmuch.usercenter.controller;


import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.itmuch.usercenter.pojo.User;
import com.itmuch.usercenter.pojo.user.JwtTokenRespDTO;
import com.itmuch.usercenter.pojo.user.LoginRespDTO;
import com.itmuch.usercenter.pojo.user.UserLoginDTO;
import com.itmuch.usercenter.pojo.user.UserRespDTO;
import com.itmuch.usercenter.service.IUserService;
import com.itmuch.usercenter.service.impl.UserServiceImpl;
import com.itmuch.usercenter.util.JwtOperator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final IUserService iUserService;
    private final WxMaService wxMaService;
    private final UserServiceImpl userService;
    private final JwtOperator jwtOperator;


    @GetMapping("/{id}")
    public User queryUserById(@PathVariable Integer id) {

        log.info("我被请求了");
        return this.iUserService.queryUserById(id);
    }


    /**
     * 模拟生成token,假登陆
     * @return
     */
    @GetMapping("/gen-koken")
    public String genToken(){
        Map<String, Object> userInfo = new HashMap<>(3);
        userInfo.put("id",1);
        userInfo.put("wxNickName", "xxx");
        userInfo.put("role", "admin");
        return this.jwtOperator.generateToken(userInfo);
    }

    @PostMapping("/login")
    public LoginRespDTO login(@RequestBody UserLoginDTO userLoginDTO) throws WxErrorException {
        // 微信小程序服务端校验是否已经登陆的结果
        WxMaJscode2SessionResult result = this.wxMaService.getUserService()
                .getSessionInfo(userLoginDTO.getCode());

        // 微信的openid,用户在微信这边的唯一标识
        String openid = result.getOpenid();

        // 看用户是否注册，如果没有注册就（插入）
        User user = this.userService.login(userLoginDTO, openid);

        // 如果已经注册就颁发token
        Map<String, Object> userInfo = new HashMap<>(3);
        userInfo.put("id",user.getId());
        userInfo.put("wxNickName", user.getWxNickname());
        userInfo.put("role", user.getRoles());

        String token = jwtOperator.generateToken(userInfo);
        log.info("用户{}登陆成功生成的token{}，有效期：{}",
                userLoginDTO.getWxNickname(),
                token,
                jwtOperator.getExpirationTime()
        );
        // 构建响应
        return LoginRespDTO.builder()
                .user(
                        UserRespDTO.builder()
                                .id(user.getId())
                                .avatarUrl(user.getAvatarUrl())
                                .bonus(user.getBonus())
                                .wxNickname(user.getWxNickname())
                                .build()
                )
                .token(
                        JwtTokenRespDTO.builder()
                                .expirationTime(jwtOperator.getExpirationTime().getTime())
                                .token(token)
                                .build()
                )
                .build();

    }


    /***
     *测试用
     [user]
     * @return {@link User}
     * @throws
     * @author 何林冲  @date 2022/3/30 10:56
     */
    @GetMapping("/q")
    public User query(User user) {
        return user;
    }


    @PostMapping("/qPost")
    public User queryPost(@RequestBody User user) {
        return user;
    }

}
