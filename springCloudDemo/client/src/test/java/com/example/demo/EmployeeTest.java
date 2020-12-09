package com.example.demo;

import com.example.demo.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: tangdy
 * @Date: 2020/12/8 15:14
 * @Vision: 1.0
 */
@SpringBootTest
public class EmployeeTest {
    @Autowired
    private EmployeeService employeeService;
    @Test
    public void get(){
        System.out.println(employeeService.selectByPrimaryKey(7));

    }
}
