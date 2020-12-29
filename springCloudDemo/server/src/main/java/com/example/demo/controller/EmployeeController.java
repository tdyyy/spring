package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * restful风格接口
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/find/{id}")
    public String getEmpById(@PathVariable int id){
        return employeeService.getById(id).toString();
    }
    @PostMapping("/add")
    public String addEmp(Employee employee){
        return employeeService.add(employee)==1?"OK":"FALL";
    }
    @PutMapping("/change")
    public String changeEmp(Employee employee){
        employeeService.change(employee);
        return employeeService.getById(employee.getId()).toString();
    }
}
