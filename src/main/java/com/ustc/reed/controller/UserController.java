package com.ustc.reed.controller;

import com.ustc.reed.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * created by reedfan on 2019/1/6 0006
 */
@RestController

public class UserController {


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


}
