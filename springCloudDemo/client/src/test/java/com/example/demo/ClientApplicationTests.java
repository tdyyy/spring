package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.impl.MqConsumerServiceImpl;
import com.google.inject.internal.cglib.core.$ClassInfo;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class ClientApplicationTests {
    private static String rokectIp = "192.168.201.130:9876";
    private Logger logger = LoggerFactory.getLogger(MqConsumerServiceImpl.class);

    public static DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("comsumerTest");

    @Test
    void contextLoads() {
    }
    @Test
    void mqConsumer(){
        consumer.setNamesrvAddr(rokectIp);
        try {
            consumer.subscribe("test","*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt ext : list) {
//                    logger.info("mq线程：{}，消息：{}",Thread.currentThread().getName(),new String(ext.getBody()));
                    Employee employee= JSONObject.parseObject(JSONObject.toJSONBytes(ext.getBody()), Employee.class);
                    logger.info("mq线程：{}，消息：{}",Thread.currentThread().getName(),employee.toString());
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        logger.info("消费者以启动");
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Object object = new Object();
        synchronized (object){
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
