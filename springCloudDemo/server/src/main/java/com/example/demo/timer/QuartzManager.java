package com.example.demo.timer;

import com.example.demo.entity.TaskVo;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Author: tangdy
 * @Date: 2020/12/28 10:57
 * @Vision: 1.0
 */
@Component
public class QuartzManager {
    @Autowired
    @Qualifier("schduler")
    private Scheduler scheduler;

    public void addJob(TaskVo taskVo){
        JobDataMap map = new JobDataMap();
        map.put("taskVo",taskVo);
        JobDetail detail = JobBuilder.newJob(QuartzTest.class).setJobData(map).build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND)).
                        withSchedule(CronScheduleBuilder.cronSchedule(taskVo.getCron())).build();
        try {
            scheduler.scheduleJob(detail,trigger);
            if(!scheduler.isShutdown()){
                scheduler.start();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
