package com.zjp.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {

    @Scheduled(cron = "0/3 * * * * *")
    public void task1(){
        System.out.println("任务执行……");
    }
}
