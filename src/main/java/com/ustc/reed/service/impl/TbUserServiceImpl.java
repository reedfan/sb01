package com.ustc.reed.service.impl;

import com.ustc.reed.mapper.TbUserMapper;
import com.ustc.reed.pojo.TbUser;
import com.ustc.reed.pojo.TbUserExample;
import com.ustc.reed.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by reedfan on 2019/1/19 0019
 */
@Service
public class TbUserServiceImpl implements TbUserService{
    @Autowired
    TbUserMapper tbUserMapper;

    TbUserExample tbUserExample = null;

    TbUserExample.Criteria criteria = null;

    @Override
    public TbUser selctUserByName(String userName) {
        tbUserExample =  new TbUserExample();
        criteria = tbUserExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<TbUser> tbUserList = tbUserMapper.selectByExample(tbUserExample);
        if(tbUserList.size()>0){
            return tbUserList.get(0);
        }
        return null;
    }
}
