package com.ustc.reed.config;

import com.ustc.reed.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * created by reedfan on 2019/1/27 0027
 */


@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
//让配置生效
public class SecurityCoreConfig {
}
