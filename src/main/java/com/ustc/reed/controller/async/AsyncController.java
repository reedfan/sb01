package com.ustc.reed.controller.async;


import com.ustc.reed.service.sync.DeferredResultHolder;
import com.ustc.reed.service.sync.MockQueue;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
/**
 * @author reed fan
 *
 */
import java.util.concurrent.Callable;

@RestController
public class AsyncController {
    private static Logger logger  = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping("/sync")
    public String sync() throws Exception{
        logger.info("主线程开始");
        Thread.sleep(1000);

        logger.info("主线程结束");
        return "success";
    }

    @GetMapping("/async")
    public Callable<String> async() throws Exception{
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
				Thread.sleep(1000);
				logger.info("副线程返回");
				return "success";
            }
        };
        logger.info("主线程结束");
        return result;
    }

    @GetMapping("/mqasync")
    public DeferredResult<String> mqasync() throws Exception{
        logger.info("主线程开始");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
        return result;

    }
}
