package com.zjp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    // 配置Swagger 的 Docket Bean 实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("张家口")
                // 是否启用Swagger 如果为false ,则 Swagger 不能在页面访问
                //.enable(false)
                .select()
                // RequestHandlerSelectors 配置要扫描接口的方式
                    // basePackage 指定要扫描的包
                    // any() : 扫描全部
                    // none() : 不扫描
                    // withClassAnnotation(Controller.class) : 扫描类上的注解，参数时一个注解的方法对象
                    // withMethodAnnotation(GetMapping.class) : 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.zjp.controller"))
                // paths() : 过滤扫描路径
                //.paths(PathSelectors.ant("/zjp/**"))
                .build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.OAS_30).groupName("B").select().build();
    }

    // 配置 Swagger 信息
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("zjp007", "https://github.com/zjp007", "906030149@qq.com");
        return new ApiInfo("Api Documentation",
                "ssmbuild Books API Doc",
                "v1.0",
                "https://github.com/zjp007",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
