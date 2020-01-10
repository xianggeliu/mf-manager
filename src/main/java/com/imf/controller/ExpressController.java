package com.imf.controller;

import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfEMessage;
import com.imf.pojo.MfExpress;
import com.imf.service.ExpressService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by JiXiang on 2019/12/26 14:28
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
//@RestController("/express")
@Controller
@RequestMapping("/express")
public class ExpressController {
    @Autowired
    private ExpressService expressService;

    /**
     * 展示所有快递
     */
    @GetMapping("/showExpress")
    @ResponseBody
//    public Object showExpress(@RequestParam(name = "mobile" ,value = "") String mobile , @RequestParam(name = "number" , value = "") String number
//            , @RequestParam(name = "eCompany" ,value ="" ) String eCompany , Integer eState , @RequestParam(name = "tState" ,value = "asc") String tState){
    public Object showExpress( String mobile ,  String number
            ,  String eCompany , Integer eState ,  String tState){
      List<MfExpress> mfExs =  expressService.getExpressAll(mobile , number , eCompany , eState , tState);

        return MFJSONResult.ok(mfExs);
    }

    /**
     * 保存短信模板
     */
    @PostMapping("/saveMessage")
    @ResponseBody
    public Object saveMessage( @RequestParam("content") String content){
        if (StringUtils.isEmpty(content)) {
            return MFJSONResult.errorMsg("短信样板不能为空~！");
        }
        try {
            return expressService.saveMessage(content);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("保存短信模板异常，请联系祥哥！");
        }
    }

    /**
     * 保存短信模板
     */
    @GetMapping("/getMessage")
    @ResponseBody
    public Object getMessage( ){
        try {
            MfEMessage message = expressService.getMessage();
            if (message != null ){
                return MFJSONResult.ok(message);
            }
            return MFJSONResult.errorMsg("获取 短信模板异常为空!");
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("保存短信模板异常，请联系祥哥！");
        }
    }

    @GetMapping("/loadCompanyName")
    @ResponseBody
    public MFJSONResult loadCompanyName(){
        try {
            return expressService.loadCompanyName();
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("获取快递公司信息异常！");
        }
    }

    @GetMapping("/loadUser")
    @ResponseBody
    public MFJSONResult loadUser(@RequestParam("mobile") String mobile){
        try {
            return expressService.loadUser(mobile);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("获取用户信息异常，请联系祥哥！");
        }
    }



    @RequestMapping("/saveExpress")
    @ResponseBody
    public MFJSONResult postExpress(@RequestParam(value = "expressNum") String expressNum, @RequestParam(value = "companyCode") String companyCode,
                                    String phone , String name ,@RequestParam(value = "state" ,defaultValue = "1") Integer state) {
        try {
            return expressService.insertExpressInfo(expressNum, companyCode, phone, name , state);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加快递信息异常，请重试！");
        }

    }

}
