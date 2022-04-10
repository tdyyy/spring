package com.example.demo.controller;

import com.example.demo.services.MqConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author TDY
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private MqConsumerService consumerService;
    @Autowired
    RestTemplate restTemplate;

    /**
     * 断路器 fallbackMethod->指定降级方法
     * url:http://${注册的服务名}/${uri}
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/hello")
    public String hello(){
        System.out.print("1");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://server/server/hello",String.class);
        return responseEntity.getStatusCode().equals(HttpStatus.OK)?responseEntity.getBody():"请求服务出现了问题，状态码："+responseEntity.getStatusCode();
    }
    public String fallback(){
        return "<h1>当前服务目前不可用<h1>";
    }

    @RequestMapping("/start")
    public void start(){
        consumerService.get();
    }


    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
//        HashMap<String,String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.keySet().forEach(s -> {
            if(s.equals("2")){
                map.remove("1");
            }
        });
    }
}
