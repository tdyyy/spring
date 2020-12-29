package com.example.demo.services;

import java.io.File;

/**
 * @Author: tangdy
 * @Date: 2020/12/22 10:55
 * @Vision: 1.0
 */
public interface FileService {
    public File getFile(String name);
    public String addFile(File file);
}
