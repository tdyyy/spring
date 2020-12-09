package com.example.demo.services.impl;

import com.example.demo.services.MqConsumerService;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MqConsumerServiceImpl implements MqConsumerService {
    private static String rokectIp = "192.168.201.130:9876";
    private Logger logger = LoggerFactory.getLogger(MqConsumerServiceImpl.class);
    /**
     * 消费者
     */
    public static DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("comsumerTest");
    static {
        // 指定服务ip
            consumer.setNamesrvAddr(rokectIp);
    }
    @Override
    public void get() {
        try {
            // 订阅的topic 消息类型
            consumer.subscribe("test","*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        // 监听
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt ext : list) {
                    logger.info("mq线程：{}，消息：{}",Thread.currentThread().getName(),ext.getBody().toString());
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        try {
            //开启消费服务
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        logger.info("消费者以启动");
    }
}
