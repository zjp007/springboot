package com.zjp.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    // cron表达式
    // 秒 分 时 日 月 星期(0/7 星期天 1-6 周一 ~ 周六)
    // ? 只能用在 日期 和 星期
    //@Scheduled(cron = "0/3 * * * * *")
    public void hello(){
        System.out.println("task hello");
    }
}
