package com.itmuch.usercenter.rocketmq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

/** rocketMQ 消费者（自定义接口消费MQ）
 * @author 何林冲
 */
@Service
@Slf4j
public class MyTestStreamConsumer {


/*    @StreamListener(MySink.MY_INPUT)
    public void receive(String messgeBody) {

        log.info("自定义接口消费：通过了stream收到了消息：messageBody={}", messgeBody);
        throw new IllegalArgumentException("抛异常");
    }*/


    /**
     * 全局异常处理
     * @param message 发送异常消息
     */
/*    @StreamListener("errorChannel")
    public void error(Message<?> message) {
        ErrorMessage errorMessage = (ErrorMessage) message;
        log.warn("发送异常，errorMessage={}",errorMessage);
    }*/

}
