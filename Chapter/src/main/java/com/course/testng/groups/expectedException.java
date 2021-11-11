package com.course.testng.groups;

import org.testng.annotations.Test;

public class expectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void RuntimeExceptionFailed(){
        System.out.println("这是一个会失败异常测试");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void RuntimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }
}
