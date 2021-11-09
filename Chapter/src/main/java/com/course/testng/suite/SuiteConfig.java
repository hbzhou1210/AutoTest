package com.course.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("beforeSuite 运行了");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("afterSuite 运行了");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }
}
