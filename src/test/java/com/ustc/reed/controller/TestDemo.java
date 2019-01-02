package com.ustc.reed.controller;

import com.ustc.reed.Sb01Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Sb01Application.class)

public class TestDemo {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeMethod
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/dept/findAll") //get请求
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                //.param("userId", "11").param("userName", "henry")//传入添加的用户参数
                .accept(MediaType.APPLICATION_JSON))  //接收的类型
                .andExpect(MockMvcResultMatchers.status().isOk())   //判断接收到的状态是否是200
                .andDo(MockMvcResultHandlers.print())  //打印内容
                .andReturn();

        //System.out.println("输出 " + mvcResult.getResponse().getContentAsString());

    }


}
