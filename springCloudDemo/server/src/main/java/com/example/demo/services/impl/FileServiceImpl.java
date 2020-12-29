package com.example.demo.services.impl;

import com.example.demo.services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author: tangdy
 * @Date: 2020/12/22 10:56
 * @Vision: 1.0
 */
@Service
public class FileServiceImpl implements FileService {
    @Value("${files.path}")
    private String FILESPATH;
    @Override
    public File getFile(String name) {
        File file = new File(FILESPATH+name);
        return file;
    }

    @Override
    public String addFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        File newFile = new File();
        return null;
    }
}
