package com.zhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Test05Application {

    public static void main(String[] args) {
        SpringApplication.run(Test05Application.class, args);
    }

}
