package com.ustc.reed.rabbitmq;

import com.ustc.reed.rabbitmq.configuration.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    public void sendMsd(String content){
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTINGKEY_A,content,correlationId);


    }


    public void sendAll(String content){
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUTEXCHANGE,content);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ask, String cause) {
        logger.info("回调id"+correlationData);
        if(ask){
            logger.info("消息成功消费");
        }else {
            logger.info("消息消费失败"+cause);
        }




    }
}
