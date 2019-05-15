package com.imf.controller.interceptor;

import com.imf.pojo.MFJSONResult;
import com.imf.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public MFJSONResult loginView(String username , String password){
        boolean doStatus  = loginService.doLogin(username,password);
        if (doStatus){
            return MFJSONResult.ok("成功了");
        }else{
            return  MFJSONResult.errorMsg("登录不成功~！");
        }
    }

}
