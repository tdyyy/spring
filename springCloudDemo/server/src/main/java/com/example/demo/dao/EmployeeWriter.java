package com.example.demo.dao;

import com.example.demo.entity.Employee;

public interface EmployeeWriter {
    public int addEmployee(Employee employee);
    public int updateEmployee(Employee employee);
    public int deleteEmployee(Employee employee);
}
