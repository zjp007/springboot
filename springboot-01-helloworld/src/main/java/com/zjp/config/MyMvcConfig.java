package com.zjp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

// 扩展 springMVC 配置
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    // public interface ViewResolver 实现了视图解析接口的类，我们就可以把它看作视图解析器

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolve();
    }

    // 自定义视图解析器 MyViewResolve
    public static class MyViewResolve implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}

