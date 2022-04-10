package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: tangdy
 * @Date: 2020/12/22 10:54
 * @Vision: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/file")
public class FileIoContreller {
//    @Value("${files.path}")
    private String FILESPATH = "D:\\file\\";
    @RequestMapping("/upload")
    public void upload(HttpServletRequest request, Employee emp){

        File dir = new File(FILESPATH);
        if(!dir.exists()){
            dir.mkdir();
        }
        log.info("map:{},emp:{}",JSONObject.toJSONString(request.getParameterMap()),emp);
        Map<String,MultipartFile> map = ((MultipartHttpServletRequest)request).getFileMap();
        for (String s : map.keySet()) {
            if(map.get(s).getSize()==0){
                continue;
            }
            MultipartFile multipartFile = map.get(s);
            File f = new File(FILESPATH+multipartFile.getOriginalFilename());
            if(!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }
            try {
                if(!f.exists()) {
                    multipartFile.transferTo(f);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("k:{},v:{}",s,multipartFile.getOriginalFilename());
        }
    }
}
