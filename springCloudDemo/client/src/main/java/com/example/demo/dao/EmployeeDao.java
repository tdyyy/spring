package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 *@Author: tangdy
 *@Date: 2020/12/8 15:13
 *@Vision: 1.0
 */
public interface EmployeeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}