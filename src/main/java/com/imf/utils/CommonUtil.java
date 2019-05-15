package com.imf.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {

    private static final Logger logger = Logger.getLogger(CommonUtil.class);

    /**
     * 获取userInfo
     *
     * @param request
     * @return
     */
    public static UserInfo getUserInfo(HttpServletRequest request, JedisClient jedisClient) {
        UserInfo userInfo = null;
        String userJson = "";
        try {
            //如果是Android登录则使用Token
            String tokenUUID = request.getParameter(configProperties.token_name);
//        tokenUUID = URLDecoder.decode(tokenUUID,"UTF-8");
            if (StringUtils.isNotBlank(tokenUUID) && StringUtils.isNotBlank(jedisClient.get(tokenUUID))) {
                userJson = jedisClient.get(tokenUUID);
            } else {
                //存放Cookie信息情况下
                CookieUtil cookieUtil = new CookieUtil();
                //cookieValue是cookie的值，也是Redis的Name
                String cookieValue = cookieUtil.findCookie(request, configProperties.cookie_Name);
                if (StringUtils.isNotBlank(cookieValue) && jedisClient.exists(cookieValue)) {
                    userJson = jedisClient.get(cookieValue);
                }
            }
        } catch (Exception e) {
            logger.error("Redis信息获取失败：" + e.getMessage());
            return null;
        } finally {
        }
        Gson gson = new Gson();
        userInfo = gson.fromJson(userJson, UserInfo.class);
        return userInfo;
    }

    /**
     * 位数不够补0的方法
     */

    public static String autoGenericCode(int code, int num) {
        String result = "";
        // num:数字位数
        // 　0 数字前边补充0
        // num代表最终数字长度
        // d代表参数为正数型
        result = String.format("%0" + num + "d", code);
        return result;
    }

    /**
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }

    /**
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {

            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
    //判断字符串中是否中文
    public static boolean HasDigit(String content) {
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher m = p.matcher(content);
        if (m.find()) {
            return true;
        }
        return false;
    }
    // 判断一个字符串是否是纯数字
   /* public static boolean HasDigit(String content) {
        boolean flag = true;
        for (int i = content.length();--i>=0;){
            if (!Character.isDigit(content.charAt(i))){
                flag= false;
            }
        }
        return flag;
    }*/


    // 获取当前指定时间的 时间戳
    public static Long getTimeStamp(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = df.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse);
        return cal.getTimeInMillis();
    }

    // 获取当前指定时间的 时间戳
    public static boolean equalTime( Date date ) throws ParseException {
        long currentTimestamps = System.currentTimeMillis();
        Long oneDayTimestamps = Long.valueOf(60 * 60 * 24 * 1000);
        long zero =currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps;
//        long zero = current/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
        long time = date.getTime();
        logger.info("现在时间的时间戳=" + time);
        logger.info("今天0点时间戳=" + zero);
        return  zero > time ? false : true;
    }

    /**
     * 将特殊字符替换为全角
     * @param s
     * @return
     */
    public static  String xssEncode(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '>':
                    sb.append('＞');// 全角大于号
                    break;
                case '<':
                    sb.append('＜');// 全角小于号
                    break;
                case '\'':
                    sb.append('‘');// 全角单引号
                    break;
                case '\"':
                    sb.append('“');// 全角双引号
                    break;
                case '&':
                    sb.append('＆');// 全角＆
                    break;
                case '\\':
                    sb.append('＼');// 全角斜线
                    break;
                case '/':
                    sb.append('／');// 全角斜线
                    break;
                case '#':
                    sb.append('＃');// 全角井号
                    break;
                case '(':
                    sb.append('（');// 全角(号
                    break;
                case ')':
                    sb.append('）');// 全角)号
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    //删除文件夹及其所有文件
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }


    //删除文件夹
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String switchString(String str){
        str = str.replace("＆ldquo;", "“");
        str = str.replace("＆ldquo;", "“");
        str = str.replace("＆rdquo;", "”");
        str = str.replace("＆rdquo;", "”");
        str = str.replace("＆nbsp;", " ");
        str = str.replace("＆quot;", "\"");
        str = str.replace("＆amp;", "＆");
        str = str.replace("＆middot;", "·");
        str = str.replace("＆lsquo;", "‘");
        str = str.replace("＆#39;", "'");
        str = str.replace("＆rsquo;", "’");
        str = str.replace("＆mdash;", "—");
        str = str.replace("＆ndash;", "–");
        str = str.replace("＆ndash;", "–");
        str = str.replace("＆hellip;", "……");
        str = str.replace("&hellip;", "……");
        str = str.replace("＆acute;", "´");
        str = str.replace("＆minus;", "−");
        str = str.replace("＆bull;", "•");
        str = str.replace("＆times;", "×");
        str = str.replace("＆＃39;", "'");
        return str;

    }



}
