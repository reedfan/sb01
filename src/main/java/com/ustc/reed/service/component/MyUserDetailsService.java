package com.ustc.reed.service.component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



/**
 * created by reedfan on 2019/1/27 0027
 */
@Component
public class MyUserDetailsService implements UserDetailsService{

    private static Logger logger = LoggerFactory.getLogger( MyUserDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;




    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        String password = passwordEncoder.encode("123456");
        logger.info("用户名为{}的用户,用密码{}登录",userName,password);
        /*
        1.用户是否失效
        2.用户账号是否过期
        3.用户凭证是否过期
        4.账号是否被锁定
         */
        return new User(userName,password,false,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
