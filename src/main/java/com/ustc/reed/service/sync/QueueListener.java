package com.ustc.reed.service.sync;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * created by reedfan on 2019/1/6
 */

@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){

                            if(StringUtils.isNotBlank(mockQueue.getCompleteOrder())){
                                String orderNumber = mockQueue.getCompleteOrder();
                                logger.info("返回订单结果："+orderNumber);
                                deferredResultHolder.getMap().get(orderNumber).setResult("place order success");
                                mockQueue.setCompleteOrder(null);
                            }else {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }
                }

        ).start();

    }
}
