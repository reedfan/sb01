package com.ustc.reed.config;

import com.ustc.reed.authentication.ReedAuthenticationSuccessHandler;
import com.ustc.reed.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * created by reedfan on 2019/1/26 0026
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ReedAuthenticationSuccessHandler reedAuthenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
              //  .loginPage("/imooc-signIn.html")     //指定登录界面
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(reedAuthenticationSuccessHandler)
       // http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrowserProperties().getLoginPage()).permitAll()      //访问这个url不需要身份认证
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();   //暂时将跨域请求伪造的功能去掉

    }
}
