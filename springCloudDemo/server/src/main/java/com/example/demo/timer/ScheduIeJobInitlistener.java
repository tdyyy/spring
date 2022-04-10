package com.example.demo.timer;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
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
    @Qualifier("schduler")
    private Scheduler scheduler;
    @Autowired
    private TaskService taskSerevice;
    @Override
    public void run(String... args) throws Exception {
//        JobDetail jobDetail = JobBuilder.newJob(ReloadTask.class).withIdentity("init","test").build();
//        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ? *")).build();
//        scheduler.scheduleJob(jobDetail,trigger);
//        if(!scheduler.isShutdown()){
//            scheduler.start();
//        }
    }
}
