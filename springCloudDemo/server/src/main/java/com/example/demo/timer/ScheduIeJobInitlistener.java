package com.example.demo.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: tangdy
 * @Date: 2020/12/28 10:40
 * @Vision: 1.0
 */
@Component
@Order(1)
public class ScheduIeJobInitlistener implements CommandLineRunner {
    @Autowired
    private TaskService taskSerevice;
    @Override
    public void run(String... args) throws Exception {
        taskSerevice.ininSchedules();
    }
}
