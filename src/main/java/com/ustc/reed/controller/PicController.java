package com.ustc.reed.controller;


import com.ustc.reed.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/pic")
public class PicController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public PicController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${upload-path}")
    private String path;

    @GetMapping("test")
    public ModelAndView toUpload(ModelAndView modelAndView){

        modelAndView.setViewName("test");

        return modelAndView;
    }



    @PostMapping("/file")
    public String upload(@RequestParam("fileName")MultipartFile file, Map<String,Object> map){
        // 要上传的目标文件存放路径
        String localPath = "/Users/qufan/Downloads/pic";
        // 上传成功或者失败的提示
        String msg = "";
        String originalFileName = file.getOriginalFilename();
        if(FileUtils.upload(file,localPath,originalFileName)){
            msg = "上传成功";
        }else {
            msg = "上传失败";
        }
        return msg;

    }






}
