package com.ustc.reed.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by reedfan on 2019/1/27 0027
 */

public class BrowserProperties {
    private static Logger logger = LoggerFactory.getLogger(BrowserProperties.class);
    private String loginPage = "/imooc-signIn.html";


    public String getLoginPage() {
        logger.info("loginPage:{}",loginPage);
        return loginPage;

    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
