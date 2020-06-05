package com.zhao.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyScheduler {
private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    相当于每隔两秒执行一次任务
//    从开始时间间隔2s执行
     @Scheduled(fixedRate = 2000)
     public void testTask(){
         System.out.println("定时任务执行时间："+format.format(new Date()));
    }

//    从执行结束时间间隔3s执行
    @Scheduled(fixedDelay = 3000)
    public void testTask2(){
        System.out.println("定时任务2执行时间："+format.format(new Date()));
    }

    @Scheduled(cron = "0 18 16 ? * *")
    public void testTask3(){
        System.out.println("定时任务3执行时间："+format.format(new Date()));
        System.out.println("=======");
    }
}
