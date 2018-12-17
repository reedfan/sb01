package com.ustc.reed.service;

import com.ustc.reed.Sb01Application;
import com.ustc.reed.Sb01ApplicationTests;
import com.ustc.reed.service.impl.HelloServiceImpl;
import com.ustc.reed.service.impl.WorldServiceImpl;
import org.junit.Before;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Sb01Application.class)
@WebAppConfiguration

public class HelloServiceTest {

   /* @Autowired
    private HelloService helloService;

    @Test
    public void test(){
        helloService.say();

    }*/

  /* @Before
    public void initMocks() throws Exception {
        MockitoAnnotations.initMocks(this);
    }*/


   @Autowired
    private HelloServiceImpl helloService;

    @Autowired
    private WorldServiceImpl worldService;

 /*  @MockBean
   private HelloServiceImpl helloService;*/




    @Test
    public void test(){
        System.out.println("start mock....");
        when(helloService.say()).thenReturn("null");
        helloService.say();

    }




}