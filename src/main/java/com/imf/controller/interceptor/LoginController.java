package com.imf.controller.interceptor;

import com.imf.pojo.MFJSONResult;
import com.imf.service.LoginService;
import com.imf.service.impl.LoginServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView loginView(String username , String password , HttpServletResponse response){
        try {
            MFJSONResult mfjsonResult = loginService.doLogin(username, password, response);
            if (mfjsonResult.getStatus() == 200){
                ModelAndView mv = new ModelAndView();

                //手动显式指定使用转发，此时springmvc.xml配置文件中的视图解析器将会失效
                mv.setViewName("forward:/mf/view");
                return  mv;
//                return "redirect:/mf/view";
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("login/dologin 登录方法失败" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
