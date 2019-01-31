package com.ustc.reed.threadPool;

import com.ustc.reed.threadPool.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncTestController {
    private static Logger logger = LoggerFactory.getLogger(AsyncTestController.class);
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/asynctest")
    public String async(){
        logger.info("主线程开始");
        for (int i = 0; i < 5; i++) {
            asyncService.executeAsync();

        }


        logger.info("主线程结束");
        return "success";
    }




}
