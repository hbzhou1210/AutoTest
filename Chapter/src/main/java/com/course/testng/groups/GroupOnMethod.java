package com.course.testng.groups;


import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @BeforeGroups("Client")
    public void BeforeGroupsOnClient(){
        System.out.println("这是客户端组之前运行的方法");
    }
    @AfterGroups("Client")
    public void AfterGroupsOnClient(){
        System.out.println("这是客户端组之后运行的方法");
    }
    @BeforeGroups("server")
    public void BeforeGroupsOnServer(){
        System.out.println("这是服务端组之前运行的方法");
    }
    @AfterGroups("server")
    public void AfterGroupsOnServer(){
        System.out.println("这是服务端组之后运行的方法");
    }

    @Test(groups = "Client")
    public void groupsClient1(){
        System.out.println("这是客户端组的测试方法1");
    }
    @Test(groups = "Client")
    public void groupsClient2(){
        System.out.println("这是客户端组的测试方法2");
    }
    @Test(groups = "server")
    public void groupsServer1(){
        System.out.println("这是服务端组的测试方法1");
    }
    @Test(groups = "server")
    public void groupsServer2(){
        System.out.println("这是服务端组的测试方法2");
    }

}
