package com.zjp.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHanderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        // 获取登录用户信息
        Object userName = request.getSession().getAttribute("userName");
        if( userName == null){
            request.setAttribute("msg", "没有权限");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        return true;
    }
}
