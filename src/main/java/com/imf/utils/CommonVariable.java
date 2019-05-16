package com.imf.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by JiXiang on 2019/5/14 22:16
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */

@Component
public class CommonVariable {



    @Value("${com.imf.token}")
    private String cookieToken;

    @Value("${com.imf.redisToken}")
    private String redisToken;

//    @Value("${com.blog.value}")
//    private String bValue;

//    @Value("${com.blog.number}")
//    private String bNumber;


    public String getCookieToken() {
        return cookieToken;
    }

    public void setCookieToken(String cookieToken) {
        this.cookieToken = cookieToken;
    }

    public String getRedisToken() {
        return redisToken;
    }

    public void setRedisToken(String redisToken) {
        this.redisToken = redisToken;
    }
}
