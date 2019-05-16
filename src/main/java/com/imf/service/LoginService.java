package com.imf.service;

import com.imf.pojo.MFJSONResult;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by JiXiang on 2019/5/14 22:15
 *
 * @author : 祥哥
 * @date : 2019/5/14 22:15
 * QQ :　２５２６３２３３０
 */
public interface LoginService {
    MFJSONResult doLogin(String userName, String pasword, HttpServletResponse response) throws UnsupportedEncodingException;
}
