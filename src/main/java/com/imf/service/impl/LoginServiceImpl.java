package com.imf.service.impl;

import com.imf.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * Created by JiXiang on 2019/5/14 22:16
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean doLogin(String userName, String pasword) {
        System.out.println("用户姓名 = " + userName);
        System.out.println("密码 = " + pasword);
        return true;
    }
}
