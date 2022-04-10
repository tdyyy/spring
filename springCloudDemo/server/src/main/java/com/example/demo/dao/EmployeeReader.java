package com.example.demo.dao;

import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Map;

/**
 *员工读取接口
 * @author TDY
 */
public interface EmployeeReader {
    /**
     * 通过id查找员工
     * @param id
     * @return
     */
    public Employee selectById(int id);

    /**
     * 通过姓名查找员工
     * @param name
     * @return
     */
    public List<Employee> selectByName(String name);
    public List<Employee> selectAll();

    public List<Map<String,String>> selectToDown(Map<String,Object> param);
}
