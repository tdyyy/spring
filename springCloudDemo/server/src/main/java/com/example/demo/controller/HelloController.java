package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/server")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Value("${serverid}")
    private String servicesId;
    @Value("${username}")
    private String username;
    @Value("${rokectIp}")
    private String rokectIp;
    @RequestMapping("/hello")
    public String hello() throws InterruptedException {
        System.out.print("1");
        Thread.sleep(1001L);
        return "<h1>hello</h1> serviceid="+servicesId;
    }
    @RequestMapping("/config")
    public String config(){
        return "hello"+username+rokectIp;
    }
}
