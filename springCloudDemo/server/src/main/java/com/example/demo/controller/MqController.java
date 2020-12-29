package com.example.demo.controller;

import com.example.demo.services.MqTestServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/mq")
public class MqController {
    @Autowired
    private MqTestServer mqTestServer;
    @RequestMapping("/send")
    public String send(){
        return mqTestServer.send();
    }

}
