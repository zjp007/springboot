package com.zjp.service;


import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service    // 放入到容器中
public class UserService {
    // 获取 provider-server 中的票
    // 要去注册中心拿到服务
    @DubboReference     // 引用，pom坐标，可以定义路径相同的接口
    TicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("注册中心拿到票: " + ticket);
    }
}
