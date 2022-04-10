package com.example.demo.entity;

import lombok.Data;

/**
 * @Author: tangdy
 * @Date: 2020/12/25 15:22
 * @Vision: 1.0
 */
@Data
public class Email {
    private String sender;
    private String receiver;
    private String title;
    private String content;
}
