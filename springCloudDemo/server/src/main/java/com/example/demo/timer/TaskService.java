package com.example.demo.timer;

import com.example.demo.entity.Employee;
import com.example.demo.entity.TaskVo;
import com.example.demo.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: tangdy
 * @Date: 2020/12/28 10:45
 * @Vision: 1.0
 */
@Component
@Slf4j
public class TaskService {
    public static ConcurrentHashMap<String,Object> map = new ConcurrentHashMap();
    @Autowired
    private QuartzManager quartzManager;
    private volatile boolean flage = true;
    @Autowired
    EmployeeService employeeService;
    public void ininSchedules(){
//        log.info("===========执行初始化方法============"+LocalDateTime.now());
        List<Employee> list = employeeService.getAll();
        ConcurrentHashMap concurrentHashMap = TaskService.map;
        for (Employee employee : list) {
            if(!concurrentHashMap.containsKey(employee.getId())){
                concurrentHashMap.put(employee.getId(),employee);
                log.info("新增emp:{}",employee);
            }
        }
        if(flage) {
            TaskVo vo = new TaskVo();
            vo.setName("测试");
            vo.setCron("0/20 * * * * ? *");
            quartzManager.addJob(vo);
            flage=false;
        }
    }
}
