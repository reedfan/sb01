package com.ustc.reed.threadPool.service.impl;

import com.ustc.reed.threadPool.service.AsyncService;
import com.ustc.reed.utils.SpringMailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AsyncServiceImpl implements AsyncService {
    @Autowired
    private SpringMailUtil springMailUtil;
    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        logger.info("start executeAsync");
        System.out.println("异步线程要做的事情");
        try {
            String[] receivers = {"m18915228146@163.com"};
            String[] ccs = {"1617950759@qq.com"};
            String title = "test";
            String content = "hello";
            springMailUtil.sendMailByText(receivers,ccs,title,content);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("可以在这里执行批量插入等耗时的事情");
        logger.info("end executeAsync");


    }
}
