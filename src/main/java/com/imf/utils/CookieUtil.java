package com.imf.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtil {

    private static int age = 2 * 60 * 60;
    private static String path = "/";


    /**
     * 用于添加cookie
     * @param name
     * @param value
     * @throws UnsupportedEncodingException
     */
    public static void addCookie(String name,String value,int age,HttpServletResponse response) throws UnsupportedEncodingException{
        Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
        c.setMaxAge(age);
        c.setPath(path);//放到应用下，让查找或者删除的时候可以查询
        response.addCookie(c);
    }

    /**
     * 缺省的cookie的生存时间addCookie方法
     * @param name
     * @param value
     * @param response
     * @throws UnsupportedEncodingException
     */
    public static void addCookie(String name,String value,HttpServletResponse response) throws UnsupportedEncodingException {
        //调上面的方法
        addCookie(name,value,age,response);
    }



    /**
     * 用于查找添加的cookie,依据cookie的名称，如果找不到就返回为空null
     * @param name
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String findCookie(HttpServletRequest request, String name) throws UnsupportedEncodingException{
        String value = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(int i = 0;i < cookies.length;i++){
                Cookie c = cookies[i];
                if(name.equals(c.getName())){
                    value = URLDecoder.decode(c.getValue(),"utf-8");
                }
            }
        }
        return value;
    }

    /**
     * 根据查询的cookie的name来删除对应的cookie
     * @param name
     */
    public static void deleteCookie(String name,HttpServletResponse response){
        Cookie c = new Cookie(name,"");
        c.setMaxAge(0);
        c.setPath(path);
        response.addCookie(c);
    }
}
