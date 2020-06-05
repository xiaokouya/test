package com.zhao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhao.mapper")
@SpringBootApplication
public class Test03Application {

    public static void main(String[] args) {
        SpringApplication.run(Test03Application.class, args);
    }

}
