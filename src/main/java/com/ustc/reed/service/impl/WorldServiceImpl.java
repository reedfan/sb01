package com.ustc.reed.service.impl;

import com.ustc.reed.service.WorldService;
import org.springframework.stereotype.Service;

@Service
public class WorldServiceImpl implements WorldService {
    @Override
    public String speak() {
        System.out.println("world");
        return "world";


    }
}
