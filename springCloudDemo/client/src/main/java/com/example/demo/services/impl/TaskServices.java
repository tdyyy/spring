package com.example.demo.services.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskServices {
    /**
     * springTask 时 分 秒 周 月 年
     * ？任意
     * *每一次
     * 0/10 0秒开始每10秒一次
     *
     * 打算测试消费mq插库的 但是这边懒得配数据库了
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void autoAddEmployee(){

    }
}
