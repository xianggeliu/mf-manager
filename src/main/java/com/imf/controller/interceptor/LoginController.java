package com.imf.controller.interceptor;

import com.imf.pojo.MFJSONResult;
import com.imf.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

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

    @RequestMapping("/dologin")
    public MFJSONResult loginView(@RequestParam("userName") String userName ,@RequestParam("pasword") String pasword){
        boolean doStatus  = loginService.doLogin(userName,pasword);
        if (doStatus){
            return MFJSONResult.ok("成功了");
        }else{
            return  MFJSONResult.errorMsg("登录不成功~！");
        }
    }

}
