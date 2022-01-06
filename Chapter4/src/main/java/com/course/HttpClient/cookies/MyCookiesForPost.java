package com.course.HttpClient.cookies;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore cookieStore;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void test1() throws IOException {
        String getUrl = this.url +bundle.getString("getCookie.uri");
        String result;
        cookieStore = new BasicCookieStore();
        HttpGet get = new HttpGet(getUrl);
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
        // 拼接最终的测试地址
        String postUrl = this.url +bundle.getString("test.post.with.cookies");
        // 声明一个client对象，用来进行方法的执行并设置cookies信息
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
        // 声明一个post方法
        HttpPost httpPost = new HttpPost(postUrl);
        // 添加参数
        JSONObject param = new JSONObject();
        param.put("name", "huhansan");
        param.put("sex", "nan");
        // 设置请求头信息
        httpPost.setHeader("content-type","application/json");
        // 将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        httpPost.setEntity(entity);
        // 声明一个对象用来存储响应结果
        String result;
        // 执行post方法
        HttpResponse httpResponse = client.execute(httpPost);
        // 获取响应结果
        result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        System.out.println(result);
    // 判断返回结果是否符合预期
        // 将返回结果字符串转换成json对象
        JSONObject resultJson = new JSONObject(result);
        // 获取到结果值
        String success = resultJson.getString("huhansan");
        String status = resultJson.getString("status");
        // 具体的判断返回结果的值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);

    }
}
