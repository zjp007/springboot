package com.zjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(HttpServletRequest request,
                        @RequestParam("username") String userName,
                        @RequestParam("password") String passWord,
                        Model model){
        if(!StringUtils.isEmpty(userName) && "123456".equals(passWord)){
            request.getSession().setAttribute("userName", "userName");
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或密码错误！");
            return "index";
        }
    }
}
