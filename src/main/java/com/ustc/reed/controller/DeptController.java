package com.ustc.reed.controller;


import com.ustc.reed.pojo.Dept;
import com.ustc.reed.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {


    @Autowired
    private DeptService deptService;


    @RequestMapping("/findAll")
    public List<Dept> findAll(){
        return deptService.findAll();
    }


}
