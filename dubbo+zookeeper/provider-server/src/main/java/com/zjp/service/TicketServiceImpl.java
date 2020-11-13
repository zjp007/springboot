package com.zjp.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

// zookeeper : 服务注册与发现
@DubboService   // 可以被扫描到，在项目一启动就自动注册到注册中心
@Component  // 使用Dubbo后尽量不要用Service注解
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "说Java";
    }
}
