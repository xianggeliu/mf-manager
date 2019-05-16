package com.imf.utils;

import com.imf.pojo.UserLogin;

public class TestDemo {

    public static void main(String[] args) {
        //插入管理员数据
        String admin = Md5Util.MD5Encode("admin", "UTF-8", true);
        System.out.println(admin);
    }

}
