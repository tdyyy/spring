package com.example.demo.services;

import com.example.demo.entity.Email;

/**
 * @Author: tangdy
 * @Date: 2020/12/25 14:55
 * @Vision: 1.0
 */
public interface MailService {
    public void send(Email email);
}
