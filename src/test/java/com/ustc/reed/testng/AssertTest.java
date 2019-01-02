package com.ustc.reed.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {

    @Test
    public void AssertTest(){

        Assert.assertEquals(1,1);
        Assert.assertEquals(1,1,"not equals");

      //  Assert.assertEquals("ABC","abc");

        Assert.assertEquals("ABC","abc","not equals");

    }


}
