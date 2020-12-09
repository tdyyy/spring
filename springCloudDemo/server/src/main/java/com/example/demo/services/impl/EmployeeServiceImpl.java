package com.example.demo.services.impl;

import com.example.demo.dao.EmployeeReader;
import com.example.demo.dao.EmployeeWriter;
import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeWriter writer;
    @Autowired
    private EmployeeReader reader;
    @Override
    public Employee getById(int id) {
        return reader.selectById(id);
    }

    @Override
    public List<Employee> getByName(String name) {
        return reader.selectByName(name);
    }

    @Override
    public int add(Employee employee) {
        return writer.addEmployee(employee);
    }

    @Override
    public int change(Employee employee) {
        return writer.updateEmployee(employee);
    }

    @Override
    public int delete(Employee employee) {
        return writer.deleteEmployee(employee);
    }
}
