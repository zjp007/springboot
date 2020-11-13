package com.zjp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 如果要扩展springmvc，官方建议我们这样去 做
@Configuration
public class MyMvcConfigTwo implements WebMvcConfigurer {

    // 试图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("/pages/data-tables.html");
        registry.addViewController("/index").setViewName("/pages/login.html");
//        registry.addViewController("/index.html").setViewName("/pages/data-tables.html");
        registry.addViewController("/login").setViewName("/pages/login.html");
        // /main.html
        registry.addViewController("/main.html").setViewName("/pages/data-tables.html");
    }

    // 自定义组件加入到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHanderInterceptor())
                .addPathPatterns("/**")         // 拦截请求
                .excludePathPatterns("/login","/index", "/user/login","/static/**");        // 拦截白名单
    }
}

