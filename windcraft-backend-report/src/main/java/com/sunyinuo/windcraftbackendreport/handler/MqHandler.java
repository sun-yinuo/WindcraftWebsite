package com.sunyinuo.windcraftbackendreport.handler;

import com.rabbitmq.client.Channel;
import com.sunyinuo.windcraftbackendreport.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RabbitMq监听
 * @author sunyinuo
 */
@Component
public class MqHandler {

    /**
     * 监听email队列
     * @param msg 消息
     * @param message 消息体
     * @param channel 新到
     */
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_REPORT})
    public void receiveEmail(Object msg, Message message, Channel channel){
        System.out.println("listener1"+msg);
    }

}
