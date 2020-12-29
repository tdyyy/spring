package com.example.demo.timer;

import com.example.demo.entity.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: tangdy
 * @Date: 2020/12/28 10:45
 * @Vision: 1.0
 */
@Component
public class TaskService {
    @Autowired
    private QuartzManager quartzManager;
    public void ininSchedules(){
        TaskVo vo = new TaskVo();
        vo.setName("测试");
        vo.setCron("0/10 * * * * ? *");
        quartzManager.addJob(vo);
    }
}
