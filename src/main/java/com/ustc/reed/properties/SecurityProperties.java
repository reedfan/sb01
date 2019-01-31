package com.ustc.reed.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * created by reedfan on 2019/1/27 0027
 */
//这个类会读取配置文件中以reed.security开头的配置
@ConfigurationProperties(prefix = "reed.security")
public class SecurityProperties {
    //browser相关的都在这
    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowserProperties() {
        return browser;
    }

    public void setBrowserProperties(BrowserProperties browser) {
        this.browser = browser;
    }
}
