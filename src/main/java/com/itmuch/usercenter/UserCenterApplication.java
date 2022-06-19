package com.itmuch.usercenter;

import com.itmuch.usercenter.rocketmq.MySink;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;


/**
 *
 * @EnableBinding(Sink.class) 是springCloud stream配置（MQ消费者）
 * @author 何林冲
 */
@MapperScan("com.itmuch.usercenter.mapper")
@SpringBootApplication
@EnableBinding({Sink.class,
        //MySink.class
})
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

}
