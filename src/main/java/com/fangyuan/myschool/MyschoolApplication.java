package com.fangyuan.myschool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.fangyuan.myschool.mapper")
public class MyschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyschoolApplication.class, args);
    }
}


