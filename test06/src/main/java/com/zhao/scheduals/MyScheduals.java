package com.zhao.scheduals;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling
public class MyScheduals {
    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //    从开始时间间隔2s执行
    @Scheduled(fixedRate = 2000)
    public void testTask(){
        System.out.println("定时任务执行时间："+format.format(new Date()));
    }
}
