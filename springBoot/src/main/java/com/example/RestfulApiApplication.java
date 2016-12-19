package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
@SpringBootApplication(exclude = { MongoAutoConfiguration.class })
@ComponentScan("com.example")
public class RestfulApiApplication {
    /**
     * main
     * <p>
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(RestfulApiApplication.class);
    }
}