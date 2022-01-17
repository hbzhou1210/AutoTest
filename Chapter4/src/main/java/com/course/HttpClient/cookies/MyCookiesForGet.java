package com.course.HttpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
<<<<<<< HEAD
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
=======
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.*;
>>>>>>> 2e947cf4554005a4867defca6bbf27cf7593d875
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
<<<<<<< HEAD
    //用来存储cookies信息的变量
    private CookieStore cookieStore;
=======
    private String result;
    //存储cookie信息变量
    private CookieStore store;
>>>>>>> 2e947cf4554005a4867defca6bbf27cf7593d875
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url")+bundle.getString("getCookie.uri");
    }
    @Test
    public void test1() throws IOException {
<<<<<<< HEAD
        String result;
        cookieStore = new BasicCookieStore();
        HttpGet get = new HttpGet(this.url);
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        // 获取cookies信息
        List<Cookie> cookies = cookieStore.getCookies();
        for(Cookie cookie:cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies key ="+name+",cookies value ="+value);
        }

    }
    @Test(dependsOnMethods = {"test1"})
    public void test2() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = bundle.getString("test.url")+uri;
        HttpGet httpGet = new HttpGet(testUrl);
        // 设置cookies信息
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
        CloseableHttpResponse response = client.execute(httpGet);
        // 获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = " + statusCode);
        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
=======
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
>>>>>>> 2e947cf4554005a4867defca6bbf27cf7593d875
}
