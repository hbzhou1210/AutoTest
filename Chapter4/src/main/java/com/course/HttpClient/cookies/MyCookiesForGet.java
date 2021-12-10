package com.course.HttpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private String result;
    //存储cookie信息变量
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url")+bundle.getString("getCookie.uri");
    }
    @Test
    public void test1() throws IOException {
        //获取cookie信息
        this.store = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();
        // 测试逻辑
        HttpGet get = new HttpGet(this.url);
        CloseableHttpResponse response = httpClient.execute(get);
        // 打印返回值
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        // 读取cookie信息
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie :cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+name);
            System.out.println("cookie value = "+value);
        }
     }
     @Test(dependsOnMethods = {"test1"})
     public void test2() throws IOException {
        // 获取需要测试的网页地址
         String testGetCookieUri;
         testGetCookieUri = bundle.getString("test.url")+bundle.getString("test.getCookie.uri");
         // 测试逻辑
         HttpGet get = new HttpGet(testGetCookieUri);
         DefaultHttpClient client = new DefaultHttpClient();
            //设置cookie信息
         client.setCookieStore(this.store);
         HttpResponse response = client.execute(get);

         // 获取响应状态码
         int statusCode = response.getStatusLine().getStatusCode();
         System.out.println(statusCode);
         if(statusCode == 200){
             // 打印返回值
             result = EntityUtils.toString(response.getEntity(),"utf-8");
             System.out.println(result);
         }

     }
}
