package com.zjp.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//自定义地区解析器
public class MyLocaleResolver implements LocaleResolver {
    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // 获取默认的地区
        Locale locale = Locale.getDefault();
        // 获取参数传递的地区
        String lang = httpServletRequest.getParameter("lang");
        if(!StringUtils.isEmpty(lang)){     // 如果请求的链接携带国际化参数
            String[] array = lang.split("_");
            Locale locale1 = new Locale(array[0], array[1]);
            return locale1;
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
