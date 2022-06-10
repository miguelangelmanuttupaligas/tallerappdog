package com.api.appdogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AppDogApplication implements WebMvcConfigurer{
    public static void main(String[] args) {
        SpringApplication.run(AppDogApplication.class, args);
    }

}
