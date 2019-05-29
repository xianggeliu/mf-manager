package com.imf.service;

import com.imf.pojo.MFJSONResult;

/**
 * Created by JiXiang on 2019/5/25 13:29
 *
 * @author : 祥哥
 * @date : 2019/5/25 13:29
 * QQ :　２５２６３２３３０
 */
public interface ExpressService {
    MFJSONResult insertExpressInfoNotCompany(String expressNum) throws Exception;

    MFJSONResult insertExpressInfo(String expressNum, String companyCode, String phone) throws Exception;

    MFJSONResult takesExpress(String expressNum)throws Exception;

    MFJSONResult getExpress(String expressNum)throws Exception;

    MFJSONResult getExpressInfo(String expressNum) throws Exception;

    MFJSONResult saveExpressInTotal(int state)throws Exception;
}
