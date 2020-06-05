package com.zhao.config;

import com.zhao.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public User getUser2(){
        return new User("1","xiaoming","123456");
    }

    @Bean(name="name2")
    public User user(){
        return new User("2","xiaowang","654321");
    }
}
