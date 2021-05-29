package com.zhengchao.routing;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 郑超
 * @create 2021/5/29
 */
@Component
public class RoutingCustomer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "directs",type = "direct"),
            key = {"info", "error", "warn"}
    ))
    public void receive1(String message) {
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "directs",type = "direct"),
            key = {"error"}
    ))
    public void receive2(String message) {
        System.out.println("message2 = " + message);
    }
}
