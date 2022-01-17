package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyGetMethod {
    @RequestMapping(value = "/getCookies")
    public String gerCookies(){
        return "恭喜你获得cookies信息成功";
    }
}
