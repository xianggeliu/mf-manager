package com.imf.controller.interceptor;

import com.imf.pojo.MFJSONResult;
import com.imf.service.LoginService;
import com.imf.service.impl.LoginServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);

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
    public MFJSONResult loginView(String username , String password , HttpServletResponse response){
        try {
            return loginService.doLogin(username,password ,response);
        } catch (UnsupportedEncodingException e) {
            logger.error("login/dologin 登录方法失败" + e.getMessage());
            e.printStackTrace();
            return MFJSONResult.errorMsg("登录异常，请联系管理员！");
        }
    }

}
