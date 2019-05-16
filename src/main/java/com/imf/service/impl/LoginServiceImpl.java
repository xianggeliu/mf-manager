package com.imf.service.impl;

import com.imf.mapper.UserLoginMapper;
import com.imf.pojo.MFJSONResult;
import com.imf.pojo.UserLogin;
import com.imf.service.LoginService;
import com.imf.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by JiXiang on 2019/5/14 22:16
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;
    private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private CommonVariable cv;


    @Override
    public MFJSONResult doLogin(String userName, String password, HttpServletResponse response) throws UnsupportedEncodingException {
        //根据账户密码去数据库查询是否存在
        UserLogin userLogin = userLoginMapper.selectByUserName(userName);
        //存在存入cookie redis中
        if (userLogin != null){
            String md5Password = Md5Util.MD5Encode(password, "UTF-8", true);
            String userPassword = userLogin.getPassword();
            if (userPassword.equals(md5Password)){
                //把用户信息存入到redis 跟cookie中
                String cookieToken = cv.getCookieToken() + System.currentTimeMillis();
                String redisToken = cv.getRedisToken() + System.currentTimeMillis();
                String userJson = JsonUtils.objectToJson(userLogin);
                //把用户信息存入redis中
                redis.set(redisToken,userJson);
                //放入cookie中
                CookieUtil.addCookie(cookieToken,redisToken,response);
                //更新用户表，记录登录时间
                userLogin.setLastLoginTime(new Date());
                userLoginMapper.updateByPrimaryKey(userLogin);
                //返回结果，提示登录成功；
                return MFJSONResult.ok();
            }else{
                return MFJSONResult.errorMsg("密码错误！");
            }
        }
        System.out.println("用户姓名 = " + userName);
        System.out.println("密码 = " + password);
        //不存在 返回false
        return MFJSONResult.errorMsg("账户不存在！");


    }
}
