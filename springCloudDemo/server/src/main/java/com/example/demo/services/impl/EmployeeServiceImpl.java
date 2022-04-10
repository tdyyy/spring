package com.example.demo.services.impl;

import com.example.demo.dao.EmployeeReader;
import com.example.demo.dao.EmployeeWriter;
import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeWriter writer;
    @Autowired
    private EmployeeReader reader;
    @Value("${temp.file.path}")
    private String TEMP_FILE_PATH;
    @Override
    public Employee getById(int id) {
        return reader.selectById(id);
    }

    @Override
    public List<Employee> getAll() {
        return reader.selectAll();
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

    @Override
    public String ExcelImport(Employee employee) {
        ExcelOutPutServers<Employee> outPutServers = new ExcelOutPutServers<>();
        Map<String,Object> param = new HashMap<>();
        param.put("start",0);
        param.put("limit",1000000);
        List<Map<String,String>> dataList = reader.selectToDown(param);
        Map<Integer,String> columnMap = new Hashtable<>();
        String fileName = TEMP_FILE_PATH+"员工信息.xlsx";
        columnMap.put(1,"id");
        columnMap.put(2,"name");
        columnMap.put(3,"sex");
        columnMap.put(4,"age");
        columnMap.put(5,"addr");
        columnMap.put(6,"tel");
        columnMap.put(7,"mail");
        Workbook workbook = outPutServers.createExcel(dataList,columnMap,fileName,null);
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
