package com.course.HttpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    @BeforeTest
    public void beforeTest(){

        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url")+bundle.getString("getCookie.uri");
    }
    @Test
    public void test1() throws IOException {
        String result;
        HttpGet get = new HttpGet(this.url);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
