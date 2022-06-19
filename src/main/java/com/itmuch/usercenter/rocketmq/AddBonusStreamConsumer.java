package com.itmuch.usercenter.rocketmq;


import com.itmuch.usercenter.mapper.BonusEventLogMapper;
import com.itmuch.usercenter.mapper.UserMapper;
import com.itmuch.usercenter.pojo.BonusEventLog;
import com.itmuch.usercenter.pojo.User;
import com.itmuch.usercenter.pojo.messaging.UserAddBonusMsgDTO;
import com.itmuch.usercenter.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/** rocketMQ 消费者
 * @author 何林冲
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddBonusStreamConsumer {

    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;
    private final UserServiceImpl userService;

    //rocketMQ 消费者
/*    @StreamListener(Sink.INPUT)
    public void receive(String messgeBody) {

        log.info("通过了stream收到了消息：messageBody={}", messgeBody);
    }*/


    /**
     *  SpringCloudStream + rocketMQ 实现分布式事务
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void receive(UserAddBonusMsgDTO message) {

        this.userService.addBonus(message);
    }
}
