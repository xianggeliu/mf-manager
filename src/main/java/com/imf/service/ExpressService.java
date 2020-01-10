package com.imf.service;

import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfEMessage;
import com.imf.pojo.MfExpress;

import java.util.List;

/**
 * Created by JiXiang on 2019/5/25 13:29
 *
 * @author : 祥哥
 * @date : 2019/5/25 13:29
 * QQ :　２５２６３２３３０
 */
public interface ExpressService {
    MFJSONResult insertExpressInfoNotCompany(String expressNum) throws Exception;

    MFJSONResult insertExpressInfo(String expressNum, String companyCode, String phone, String name, int state) throws Exception;

    MFJSONResult takesExpress(String expressNum)throws Exception;

    MFJSONResult getExpress(String expressNum)throws Exception;

    MFJSONResult getExpressInfo(String expressNum) throws Exception;

    MFJSONResult saveExpressInTotal(int state)throws Exception;

    /**
     * 获取所有的快递信息
     * @return
     * @param mobile
     * @param number
     * @param eCompany
     * @param eState
     * @param tState
     */
    List<MfExpress> getExpressAll(String mobile, String number, String eCompany, Integer eState, String tState);

    /**
     * 保存短信样板
     * @param content
     * @return
     */
    Object saveMessage(String content);

    /**
     * 获取短信模板信息
     * @return
     */
    MfEMessage getMessage();

    /**
     * 获取所有快递公司信息
     * @return
     */
    MFJSONResult loadCompanyName();

    /**
     * 通过手机号获取用户信息
     * @param mobile
     * @return
     */
    MFJSONResult loadUser(String mobile);

}
