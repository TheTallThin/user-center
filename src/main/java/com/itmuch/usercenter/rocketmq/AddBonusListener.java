package com.itmuch.usercenter.rocketmq;

import com.itmuch.usercenter.mapper.BonusEventLogMapper;
import com.itmuch.usercenter.mapper.UserMapper;
import com.itmuch.usercenter.pojo.BonusEventLog;
import com.itmuch.usercenter.pojo.User;
import com.itmuch.usercenter.pojo.messaging.UserAddBonusMsgDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * rocketMQ 消费者
 * topic = "add-bonus"  必须跟生产机的topic 一样，否则收不到消息
 * consumerGroup = "consumer-group" 随便写，但一定要有
 *
 * 使用rocketMQ消费消息 注释掉，用SpringCloudStream + rocketMQ 实现分布式事务 在类AddBonusStreamConsumer
 * @author 何林冲
 */
/*@Service
@RocketMQMessageListener(topic = "add-bonus", consumerGroup = "consumer-group")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AddBonusListener implements RocketMQListener<UserAddBonusMsgDTO> {

    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public void onMessage(UserAddBonusMsgDTO message) {
        // 当收消息的时候，执行的业务
        // 1.为用加积分
        Integer userId = message.getUserId();
        Integer bonus = message.getBonus();
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
}*/
