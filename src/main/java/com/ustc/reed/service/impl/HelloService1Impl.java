package com.ustc.reed.service.impl;

import com.ustc.reed.service.HelloService;
import org.springframework.stereotype.Service;

@Service("helloService1Impl")
public class HelloService1Impl implements HelloService {


    @Override
    public String say() {
        return "jj";
    }

    @Override
    public String getPassWord(String userName) {
        return null;
    }
}
