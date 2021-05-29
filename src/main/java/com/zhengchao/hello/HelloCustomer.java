package com.zhengchao.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author 郑超
 * @create 2021/5/29
 */
@Component
// 监听hello队列 ; durable是否持久化 autoDelete是否自动删除
@RabbitListener(queuesToDeclare =
    @Queue(value = "hello"/*, durable = "false", autoDelete = "true"*/))
public class HelloCustomer {

    @RabbitHandler// 表示此方法是回调方法
    public void receiveMessage(String message) {
        System.out.println("message = " + message);
    }
}
