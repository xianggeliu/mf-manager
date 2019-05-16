package com.imf.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * Created by JiXiang on 2019/5/14 22:16
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
public class CommonVariable {
    @Autowired
    private static Environment evn;


    public static String COOKIE_TOKEN = evn.getProperty("com.imf.token");
    public static String  REDIS_LOGIN= evn.getProperty("com.imf.redisToken");

}
