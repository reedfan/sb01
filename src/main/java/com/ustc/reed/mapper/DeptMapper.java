package com.ustc.reed.mapper;

import com.ustc.reed.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
@Mapper

public interface DeptMapper {
    List<Dept> findAll();

    void addDept(Dept dept);
}
