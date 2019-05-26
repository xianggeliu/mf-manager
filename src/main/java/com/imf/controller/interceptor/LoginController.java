package com.imf.controller.interceptor;

import com.imf.pojo.MFJSONResult;
import com.imf.service.ExpressService;
import com.imf.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private ExpressService expressService;

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

    @RequestMapping("/express")
    public String express(){
        return "thymeleaf/mf/expressage/express";
    }

    @RequestMapping("/expressInto")
    public String expressInto(){
        return "thymeleaf/mf/expressage/expressInto";
    }

    @RequestMapping("/expressOut")
    public String expressOut(){
        return "thymeleaf/mf/expressage/expressOut";
    }

    @RequestMapping("/expressSearch")
    public String expressSearch(){
        return "thymeleaf/mf/expressage/expressSearch";
    }

    @RequestMapping("/expressShow")
    public String expressShow(){
        return "thymeleaf/mf/expressage/expressShow";
    }

    @RequestMapping("/postExpress")
    @ResponseBody
    public MFJSONResult postExpress(@RequestParam(value="expressNum")String expressNum , @RequestParam(value="companyCode")String companyCode){
        try {
            if (StringUtils.isEmpty(companyCode)){
                return   expressService.insertExpressInfoNotCompany(expressNum);
            }else {
                return   expressService.insertExpressInfo(expressNum , companyCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加快递信息异常，请重试！");
        }

    }

    @RequestMapping("/takesExpress")
    @ResponseBody
    public MFJSONResult takesExpress(@RequestParam(value="expressNum")String expressNum){
        try {
                return   expressService.takesExpress(expressNum);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加快递信息异常，请重试！");
        }

    }

    @RequestMapping("/getExpress")
    @ResponseBody
    public MFJSONResult getExpress(@RequestParam(value="expressNum")String expressNum){
        try {
                return   expressService.getExpress(expressNum);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加快递信息异常，请重试！");
        }

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
