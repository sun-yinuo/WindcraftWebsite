package com.sunyinuo.windcraftbackendbackstage.handler;

import com.sunyinuo.windcraftbackendbackstage.config.RabbitmqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * RabbitMq监听
 * @author sunyinuo
 */
@Component
@Slf4j
public class MqHandler {

    RedisTemplate<Object,Object> redisTemplate;

    public MqHandler(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    /**
     * 监听email队列
     * @param message 消息体
     */
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_REPORT})
    public void receiveEmail(Message message){
        redisTemplate.opsForValue().set(new String(message.getBody()),"reportCache");
        log.info("backstageMQHandler存入消息至redis");
    }

}
