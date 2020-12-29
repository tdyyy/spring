package com.example.demo.timer;

import com.example.demo.entity.TaskVo;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: tangdy
 * @Date: 2020/12/28 0:01
 * @Vision: 1.0
 */
@Slf4j
@Component
public class QuartzTest implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap map =  context.getJobDetail().getJobDataMap();
        TaskVo vo = (TaskVo)map.get("taskVo");
        System.out.println("任务名: "+vo.getName()+" 当前时间："+ LocalDate.now().format(DateTimeFormatter.ISO_DATE));
    }
}
