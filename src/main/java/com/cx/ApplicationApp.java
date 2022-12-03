package com.cx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"cn.hutool.extra.spring", "com.cx"})
public class ApplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationApp.class);
    }
}
