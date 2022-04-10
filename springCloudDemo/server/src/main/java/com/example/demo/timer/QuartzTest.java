package com.example.demo.timer;

import com.example.demo.entity.Employee;
import com.example.demo.entity.TaskVo;
import com.example.demo.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: tangdy
 * @Date: 2020/12/28 0:01
 * @Vision: 1.0
 */
@Slf4j
@Component
public class QuartzTest implements Job {
    @Autowired
    EmployeeService employeeService;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap map =  context.getJobDetail().getJobDataMap();
        TaskVo vo = (TaskVo)map.get("taskVo");
        log.info("当前队列记录条数:{}",TaskService.map.size());
    }
}
