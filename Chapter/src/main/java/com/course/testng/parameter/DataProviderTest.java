package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider="data")
    public void testDataProvider(String name,int age){
        System.out.println("name="+name+",age="+age);
    }
    @DataProvider(name = "data")
    public Object [][] privaterData(){
        Object o[][]=new Object [][]{
            {"zhangsan",18},
            {"lisi",19},
            {"wangwu",20}
        };
        return o;
    }
    @Test(dataProvider = "methodDate")
    public void test1(String name,int age){
        System.out.println("test111的测试方法：name="+name+",age="+age);
    }
    @Test(dataProvider = "methodDate")
    public void test2(String name,int age){
        System.out.println("test222的测试方法：name="+name+",age="+age);
    }
    @DataProvider(name="methodDate")
    public Object [][] methodDataTest(Method method){
        Object[][] result = null;
        if(method.getName().equals("test1")){
            result=new Object[][]{
                    {"zhangsan",40},
                    {"lisi",50}
            };
        }else if (method.getName().equals("test2")){
            result=new Object[][]{
                    {"wangwu",70},
                    {"zhaoliu",80}
            };
        }
        return result;
    }
}
