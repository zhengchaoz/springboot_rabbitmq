package com.zhengchao;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    // 直连
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello", "你好啊！");
    }
    
    @Test
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "work模型" + i);
        }
    }

    // 广播
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs", "", "Fanout模型发送的消息");
    }

    // 路由
    @Test
    public void testRouting(){
        rabbitTemplate.convertAndSend("directs", "info", "发送info的key路由消息");
    }

    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics", "user.save", "user.save的消息");
    }

}
