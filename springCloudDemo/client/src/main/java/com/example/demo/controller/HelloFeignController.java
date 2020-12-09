package com.example.demo.controller;

import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TDY
 */
@RestController
@RequestMapping("/feign")
public class HelloFeignController {
    @Autowired
    FeignServices feignServices;
    @RequestMapping("/hello")
    public String hello(){
        return feignServices.hello();
    }
}
