package com.imf.service.impl;

import com.imf.service.LoginService;

/**
 * Created by JiXiang on 2019/5/14 22:16
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean doLogin(String userName, String pasword) {
        System.out.println("用户姓名 = " + userName);
        System.out.println("密码 = " + pasword);
        return false;
    }
}
