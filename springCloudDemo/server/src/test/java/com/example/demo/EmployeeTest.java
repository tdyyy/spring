package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
    @Autowired
    private EmployeeService service;
    @Test
    public void get(){
        System.out.println(service.getById(1));
    }
    @Test
    public void add(){
        Employee employee = new Employee();
        employee.setName("王凯");
        employee.setAge(23);
        employee.setAddr("长治");
        employee.setMail("wangkai@163.com");
        employee.setSex("男");
        employee.setTel("13645625890");
        System.out.println(service.add(employee));
    }
    @Test
    public void change(){
        Employee employee = new Employee();
        employee.setId(7);
        employee.setSex("女");
        System.out.println(service.change(employee));
    }

    @Test
    public void exceldown(){
        Employee employee = new Employee();
        employee.setId(7);
        employee.setSex("女");
        service.ExcelImport(employee);
        System.out.println(service.change(employee));
    }
}
