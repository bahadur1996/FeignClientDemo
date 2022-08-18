package com.example.feginclientdemo;

import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableFeignClients
public class FeginClientDemoApplication implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(FeginClientDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("111209961462487","EAAYg9cZAkAXkBAHRv4lodGiUdy37mvNgJZBnjWeZChE42MZC1z5oNu03P8m958ZBqJZB3x59ETNmDNlapYbjfbZBhnl6sGbKbir4U1RGn7vTBqn9RIUI24GQJ1VSlGD80UjgukDI595VYiUNlMLoeVY3Ma2kFuL4OtgIVZBhhuUUu7Tb45mSGFLbiULxYeBVTaG0YS2ZBUZCWo8gZDZD");
        Map<String,String> map = new HashMap<>();
        map.put("contentType","application/x-www-form-urlencoded; charset=UTF-8");
        HttpResponse httpResponse = RestApiCallerUtil.servePostRequest("https://bkash-social-gateway.revechat.com/webhook/facebook/facebook-webhook/addMenu?account_id=9971028&api_key=reve_chat_test_key",
               jsonObject, null );
        System.out.println(httpResponse);

    }
}
