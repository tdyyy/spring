package com.example.demo.services.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *@Author: tangdy
 *@Date: 2020/12/8 15:13
 *@Vision: 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return employeeDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Employee record) {
        return employeeDao.insert(record);
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeDao.insertSelective(record);
    }

    @Override
    public Employee selectByPrimaryKey(Integer id) {
        return employeeDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return employeeDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeDao.updateByPrimaryKey(record);
    }

}
