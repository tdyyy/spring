package com.example.demo.services;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployeeService {
    public Employee getById(int id);
    public List<Employee> getAll();
    public List<Employee> getByName(String name);
    public int add(Employee employee);
    public int change(Employee employee);
    public int delete(Employee employee);
    public String ExcelImport(Employee employee);
}
