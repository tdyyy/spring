package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

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
    @GetMapping("/down")
    public ResponseEntity<byte[]> ExcelDown(HttpServletResponse response){

        String path = employeeService.ExcelImport(null);
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + file.getName());
        ResponseEntity<byte[]> responseEntity;
        try {
            return responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers,HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseEntity = new ResponseEntity("error", HttpStatus.BAD_REQUEST);
    }
}
