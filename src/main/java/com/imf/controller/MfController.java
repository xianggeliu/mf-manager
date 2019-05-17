package com.imf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JiXiang on 2019/5/17 17:16
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
@Controller
@RequestMapping("/mf")
public class MfController {

    @RequestMapping("/view")
    public String getStudentMananger(){
        return "thymeleaf/mf/MfIndex";
    }

    @RequestMapping("/studentManagerView")
    public String getStudentList(){
        return "thymeleaf/mf/MfIndex";
    }

}
