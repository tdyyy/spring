package com.example.demo.entity;

import java.util.Date;
import lombok.Data;

/**
 * @Author: tangdy
 * @Date: 2020/12/8 15:13
 * @Vision: 1.0
 */
@Data
public class Employee {
    /**
     * 员工id
     */
    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工性别
     */
    private String sex;

    /**
     * 员工年龄
     */
    private Integer age;

    /**
     * 员工地址
     */
    private String addr;

    /**
     * 员工电话
     */
    private String tel;

    /**
     * 员工邮箱
     */
    private String mail;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}