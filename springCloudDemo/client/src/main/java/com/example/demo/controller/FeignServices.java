package com.example.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * feign的调用方式 先定义一个接口
 * name 注册的服务名
 * mapping 需要调用接口的地址
 */
@FeignClient(name="server")
public interface FeignServices {
    @RequestMapping("/server/hello")
    public String hello();
}
