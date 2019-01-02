package com.ustc.reed.service.impl;

import com.ustc.reed.service.HelloService;
import com.ustc.reed.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("helloServiceImpl")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private WorldService worldService;
    @Override
    public String say() {
        System.out.println("hello");
        String str = worldService.speak();
        System.out.println("reed");
        return str;


    }

    @Override
    @Cacheable(cacheNames = {"nihao","hello"}, key = "#p0")
    public String getPassWord(String userName) {
        return "reed";
    }
}
