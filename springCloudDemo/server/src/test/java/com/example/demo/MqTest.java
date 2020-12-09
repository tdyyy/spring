package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.services.impl.MqTestServerImpl;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MqTest {
    private static String rokectIp = "192.168.201.130:9876";
    private DefaultMQProducer mqProducer = new DefaultMQProducer("empdemo");
    private Logger logger = LoggerFactory.getLogger(MqTestServerImpl.class);
    @Test
    public void sendEmp(){
        mqProducer.setNamesrvAddr("192.168.201.130:9876");
        try {
            mqProducer.start();
            Employee employee = new Employee();
            employee.setName("haha");
            employee.setSex("男");
            employee.setTel("13786950030");
            employee.setAge(22);
            Message message = new Message("test",employee.toString().getBytes());
            SendResult  result= mqProducer.send(message);
            System.out.println(result.toString());
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void str() {
        String o = "hbcivsjkdvkbyabcbnjklvbauyibjcklnuqih";
        String s = "bcb";
        System.out.println(myIndexOf(o,s));
    }

    private int myIndexOf(String orgStr,String str){
        if(str.length()>orgStr.length()){
            return -1;
        }
        char[] orgchars = orgStr.toCharArray();
        char[] chars = str.toCharArray();
        for (int i = 0; i < orgchars.length-chars.length; i++) {
            for (int l = 0; l < chars.length; l++) {
                if(orgchars[i+l]!=chars[l]){
                    break;
                }
                if(l==chars.length-1){
                    return i;
                }
            }
        }
        return -1;
    }
}
