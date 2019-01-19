package com.ustc.reed.controller;

import com.ustc.reed.pojo.TbUser;
import com.ustc.reed.pojo.User;
import com.ustc.reed.service.TbUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * created by reedfan on 2019/1/6 0006
 */
@RestController

public class UserController {

    @Autowired
    TbUserService tbUserService;


    @PostMapping
    @ApiOperation(value = "创建用户")
    @RequestMapping("/user")
    public User create(@Valid @RequestBody User user) {

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }


    @GetMapping("/getUserByName")
    public TbUser getUserByName(String userName){
        return tbUserService.selctUserByName(userName);
    }


}
