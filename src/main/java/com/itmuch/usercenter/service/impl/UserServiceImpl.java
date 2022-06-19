package com.itmuch.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itmuch.usercenter.mapper.BonusEventLogMapper;
import com.itmuch.usercenter.pojo.BonusEventLog;
import com.itmuch.usercenter.pojo.User;
import com.itmuch.usercenter.mapper.UserMapper;
import com.itmuch.usercenter.pojo.messaging.UserAddBonusMsgDTO;
import com.itmuch.usercenter.pojo.user.UserLoginDTO;
import com.itmuch.usercenter.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 分享 服务实现类
 * </p>
 *
 * @author hlc
 * @since 2022-03-06
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private BonusEventLogMapper bonusEventLogMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUserById(Integer id) {
        return this.userMapper.selectById(id);
    }


    @Transactional(rollbackFor = Exception.class)
    public void addBonus(UserAddBonusMsgDTO bonusMsgDTO) {
        // 当收消息的时候，执行的业务
        // 1.为用加积分
        Integer userId = bonusMsgDTO.getUserId();
        Integer bonus = bonusMsgDTO.getBonus();
        User user = this.userMapper.selectById(userId);
        user.setBonus(user.getBonus() + bonus);
        this.userMapper.updateById(user);
        // 2.记录日志到bonus_event_log表里面
        this.bonusEventLogMapper.insert(
                BonusEventLog.builder()
                        .userId(userId)
                        .value(bonus)
                        .event("CONTRIBUTE")
                        .description("投稿加积分")
                        .createTime(LocalDateTime.now())
                        .build());
        log.info("积分添加完毕！！");
    }


    public User login(UserLoginDTO loginDTO, String openId) {

        User wxId = this.userMapper.selectOne(new QueryWrapper<User>().eq("wx_ide", openId));
        if (wxId == null) {
            User user =User.builder()
                    .wxId(openId)
                    .bonus(300)
                    .wxNickname(loginDTO.getWxNickname())
                    .avatarUrl(loginDTO.getAvatarUrl())
                    .roles("user")
                    .createTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now())
                    .build();
            int user1 = this.userMapper.insert(user);

            return user;
        }
        return wxId;
    }

}
