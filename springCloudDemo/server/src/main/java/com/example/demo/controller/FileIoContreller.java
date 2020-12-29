package com.example.demo.controller;

import org.apache.http.HttpRequest;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @Author: tangdy
 * @Date: 2020/12/22 10:54
 * @Vision: 1.0
 */
@RestController
@RequestMapping("/file")
public class FileIoContreller {
    @Value("${files.path}")
    private String FILESPATH;
    public File getFile(){
        return null;
    }
    @RequestMapping("/upload")
    public void upload(HttpServletRequest request, HttpServletResponse response){

        File dir = new File(FILESPATH);
        if(!dir.exists()){
            dir.mkdir();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
//        fileUpload.parseRequest(request.getServletContext());

    }
}
