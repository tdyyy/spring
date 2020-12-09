package com.example.demo.services.impl;

import com.example.demo.services.MqTestServer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.protocol.MQProtosHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MqTestServerImpl implements MqTestServer {

    private static String rokectIp = "192.168.201.130:9876";

    private Logger logger = LoggerFactory.getLogger(MqTestServerImpl.class);
    private static DefaultMQProducer mqProducer = new DefaultMQProducer("clouddemo");
    static {
        mqProducer.setNamesrvAddr(rokectIp);
        try {
            mqProducer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String send(){
        try {
            Message message = new Message();
            message.setTopic("test");
            message.setBody(UUID.randomUUID().toString().getBytes());
            SendResult result = mqProducer.send(message);
            return result.toString();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
