package com.imooc.controller.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/index")
    public String login(){
        return "thymeleaf/mf/index";
    }

    @RequestMapping("/reg")
    public String reg(){
        return "thymeleaf/mf/reg";
    }

    @RequestMapping("/getpass")
    public String getpass(){
        return "thymeleaf/mf/getpass";
    }

    @RequestMapping("/loginView")
    public String loginView(){
        return "thymeleaf/mf/MfIndex";
    }

}
