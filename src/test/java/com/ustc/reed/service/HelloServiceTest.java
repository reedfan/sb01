package com.ustc.reed.service;

import com.ustc.reed.Sb01Application;
import com.ustc.reed.Sb01ApplicationTests;
import com.ustc.reed.service.impl.HelloServiceImpl;
import com.ustc.reed.service.impl.WorldServiceImpl;
import org.junit.Before;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeClass;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
/* @SpringBootTest(classes = Sb01Application.class)
@WebAppConfiguration*/

public class HelloServiceTest {




    @InjectMocks
    private HelloService helloService;

    @Mock
    private WorldService worldService;


    @BeforeClass
    public void setup(){
   //     MockitoAnnotations.initMocks(this);
        Mockito.when(worldService.speak()).thenReturn("xixihaha");
      //  when(helloService.say()).thenReturn("heng");

    }




    @Test
    public void test(){
        System.out.println("start mock....");
      //  when(helloService.say()).thenReturn("null");
        System.out.println(helloService.say());

        verify(worldService,times(3));

        System.out.println("end mock....");
    }




}