package com.sunyinuo.windcraftbackendbackstage.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbitmq配置类
 * @author martin
 */
@Configuration
public class RabbitmqConfig {

    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    public static final String EXCHANGE_TOPICS_INFORM="exchange_topics_inform";
    public static final String ROUTING_KEY_EMAIL="inform.#.email.#";
    public static final String ROUTING_KEY_SMS="inform.#.sms.#";

    /**
     * 声明交换机
     * @return 交换机
     */
    @Bean(EXCHANGE_TOPICS_INFORM)
    public Exchange exchangeTopicsInform(){
        //持久化，mq重启之后交换机还在
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_INFORM).durable(true).build();
    }

    /**
     * 声明QUEUE_INFORM_EMAIL队列
     * @return 队列
     */
    @Bean(QUEUE_INFORM_EMAIL)
    public Queue queueInformEmail(){
        return new Queue(QUEUE_INFORM_EMAIL);
    }

    /**
     * 声明QUEUE_INFORM_SMS队列
     * @return 队列
     */
    @Bean(QUEUE_INFORM_SMS)
    public Queue queueInformSms(){
        return new Queue(QUEUE_INFORM_SMS);
    }

    /**
     * ROUTING_KEY_EMAIL队列绑定交换机，指定routingKey
     * @param queue 队列
     * @param exchange 交换机
     * @return 绑定
     */
    @Bean
    public Binding bindingQueueInformEmail(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue,
                                           @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_EMAIL).noargs();
    }

    /**
     * ROUTING_KEY_SMS队列绑定交换机，指定routingKey
     * @param queue 队列
     * @param exchange 交换机
     * @return 绑定
     */
    @Bean
    public Binding bindingRoutingKeySms(@Qualifier(QUEUE_INFORM_SMS) Queue queue,
                                        @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_SMS).noargs();
    }

}
