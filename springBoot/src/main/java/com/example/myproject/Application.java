package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
@RestController
@EnableAutoConfiguration
public class Application {

        @RequestMapping("/")
        String home() {
            return "Hello World!";
        }

        @RequestMapping("/now")
        String hehe() {
            return "现在时间：" + (new Date()).toLocaleString();
        }


    public static void main(String[] args) {
        SpringApplication.run(com.example.myproject.Application.class, args);
    }
}
