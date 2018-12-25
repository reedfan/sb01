package com.ustc.reed.service.impl;

import com.ustc.reed.mapper.DeptMapper;
import com.ustc.reed.pojo.Dept;
import com.ustc.reed.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        List<Dept> list = deptMapper.findAll();
        return list;
    }
}
