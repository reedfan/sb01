package com.ustc.reed.mock;

import org.mockito.InOrder;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MockTest {

    @Test
    public void test1(){
        ArrayList list = Mockito.mock(ArrayList.class);
        System.out.println(list.get(0));
        list.add(1);
        System.out.println(list.get(0));

        Mockito.when(list.get(0)).thenReturn("first");
        System.out.println(list.get(0));


        list.add("onece");
        list.add("twice");
        list.add("twice");

        Mockito.verify(list).add("onece");

        Mockito.verify(list,times(2)).add("twice");


    }
    @Test
    public void test2(){
        ArrayList list = Mockito.mock(ArrayList.class);

        Mockito.doThrow(new RuntimeException("clear exeception")).when(list).clear();

        list.clear();

    }

    //模拟调用方法时参数匹配
    @Test
    public void test3(){
        ArrayList list = Mockito.mock(ArrayList.class);

        Mockito.when(list.get(anyInt())).thenReturn("element");

        System.out.println(list.get(0));

    }
    // 校验方法调用次数

    @Test
    public void test4(){
        ArrayList list = Mockito.mock(ArrayList.class);

        list.add("onece");
        list.add("twice");
        list.add("twice");

        Mockito.verify(list).add("onece");

        Mockito.verify(list,times(2)).add("twice");

    }

    //校验某个方法是否被调用

    @Test
    public void test5(){
        ArrayList list = Mockito.mock(ArrayList.class);

        list.add("one");
        list.clear();

        Mockito.verify(list).add("one");
        Mockito.verify(list).clear();

    }

    @Test
    public void test6(){
        ArrayList singleMock = Mockito.mock(ArrayList.class);

        singleMock.add("first");
        singleMock.add("second");

        InOrder inOrder = inOrder(singleMock);

        inOrder.verify(singleMock).add("first");

        inOrder.verify(singleMock).add("second");



        //按特定顺序使用多个模拟
        ArrayList firstMock = mock(ArrayList.class);
        ArrayList secondMock = mock(ArrayList.class);
        firstMock.add("first");
        secondMock.add("second");


        inOrder = inOrder(firstMock,secondMock);
        inOrder.verify(firstMock).add("first");
        inOrder.verify(secondMock).add("second");




    }


}
