package com.imf.utils;

import com.imf.pojo.MfMsg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsSample {

	public static void main(String[] args) {

		String testUsername = "xianggeliu"; //在短信宝注册的用户名
		String testPassword = ""; //在短信宝注册的密码
		String testPhone = "13353645390";
		String testContent = "【快递综合服务】您好，请凭取件码：123，至取件东街东大路向北150米路东。快件暂存两日，若有问题请咨询18201128350。"; // 注意测试时，也请带上公司简称或网站签名，发送正规内容短信。千万不要发送无意义的内容：例如 测一下、您好。否则可能会收不到

		String httpUrl = "http://api.smsbao.com/sms";

		StringBuffer httpArg = new StringBuffer();
		httpArg.append("u=").append(testUsername).append("&");
		httpArg.append("p=").append(md5(testPassword)).append("&");
		httpArg.append("m=").append(testPhone).append("&");
		httpArg.append("c=").append(encodeUrlString(testContent, "UTF-8"));
//
//		String result =request(httpUrl, httpArg.toString());
//		System.out.println(result);
	}


	public static String sendMsg(String phnoe, String content, MfMsg mfMsg)throws Exception{
//        String testUsername = "xianggeliu"; //在短信宝注册的用户名
        String testUsername = mfMsg.getUsername(); //在短信宝注册的用户名
//        String testPassword = "xiang123"; //在短信宝注册的密码
        String testPassword = mfMsg.getPassword(); //在短信宝注册的密码
        String httpUrl = "http://api.smsbao.com/sms";
        StringBuffer httpArg = new StringBuffer();
        httpArg.append("u=").append(testUsername).append("&");
        httpArg.append("p=").append(md5(testPassword)).append("&");
        httpArg.append("m=").append(phnoe).append("&");
        httpArg.append("c=").append(encodeUrlString(content.toString(), "UTF-8"));
        return "0" ;
//	    return request(httpUrl, httpArg.toString());
    }

	public static String request(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = reader.readLine();
			if (strRead != null) {
				sbf.append(strRead);
				while ((strRead = reader.readLine()) != null) {
					sbf.append("\n");
					sbf.append(strRead);
				}
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String md5(String plainText) {
		StringBuffer buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}

	public static String encodeUrlString(String str, String charset) {
		String strret = null;
		if (str == null)
			return str;
		try {
			strret = java.net.URLEncoder.encode(str, charset);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return strret;
	}
}
