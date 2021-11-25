package com.course.testng.multithread;

import org.testng.annotations.Test;

public class multithreadOnXml {
    @Test(invocationCount = 3,threadPoolSize = 3)
    public void test1(){
        System.out.println("hello1");
        System.out.printf("Thread Id : %s%n ",Thread.currentThread().getId());
    }
    @Test(invocationCount = 3,threadPoolSize = 3)
    public void test2(){
        System.out.println("hello2");
        System.out.printf("Thread Id : %s%n ",Thread.currentThread().getId());
    }

}
