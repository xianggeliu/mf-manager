package com.imf.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class Md5Util {

	    /** 16进制的字符数组 */
	    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
	            "e", "f" };

	    /**
	     * 
	     * 
	     * @param source
	     *            需要加密的原字符串
	     * @param encoding
	     *            指定编码类型
	     * @param uppercase
	     *            是否转为大写字符串
	     * @return
	     */
	    public static String MD5Encode(String source, String encoding, boolean uppercase) {
	        String result = null;
	        try {
	            result = source;
	            // 获得MD5摘要对象
	            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	            // 使用指定的字节数组更新摘要信息
	            messageDigest.update(result.getBytes(encoding));
	            // messageDigest.digest()获得16位长度
	            result = byteArrayToHexString(messageDigest.digest());

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return uppercase ? result.toUpperCase() : result;
	    }

	    /**
	     * 转换字节数组为16进制字符串
	     * 
	     * @param bytes
	     *            字节数组
	     * @return
	     */
	    private static String byteArrayToHexString(byte[] bytes) {
	        StringBuilder stringBuilder = new StringBuilder();
	        for (byte tem : bytes) {
	            stringBuilder.append(byteToHexString(tem));
	        }
	        return stringBuilder.toString();
	    }

	    /**
	     * 转换byte到16进制
	     * 
	     * @param b
	     *            要转换的byte
	     * @return 16进制对应的字符
	     */
	    private static String byteToHexString(byte b) {
	        int n = b;
	        if (n < 0) {
	            n = 256 + n;
	        }
	        int d1 = n / 16;
	        int d2 = n % 16;
	        return hexDigits[d1] + hexDigits[d2];
	    }
	    
	    
	    /**
		 * 
		 * @param pwd
		 *            需要加密的字符串
		 * @param type
		 *            字母大小写(false为默认小写，true为大写)
		 * @param bit
		 *            加密的类型（16,32,64）
		 * @return
		 */
		public static String getMD5(String pwd, boolean isUpper, Integer bit) {
			String md5 = new String();
			try {
				// 创建加密对象
				MessageDigest md = MessageDigest.getInstance("md5");
				if (bit == 64) {
					BASE64Encoder bw = new BASE64Encoder();
					String bsB64 = bw.encode(md.digest(pwd.getBytes("utf-8")));
					md5 = bsB64;
				} else {
					// 计算MD5函数
					md.update(pwd.getBytes());
					byte b[] = md.digest();
					int i;
					StringBuffer sb = new StringBuffer("");
					for (int offset = 0; offset < b.length; offset++) {
						i = b[offset];
						if (i < 0)
							i += 256;
						if (i < 16)
							sb.append("0");
						sb.append(Integer.toHexString(i));
					}
					md5 = sb.toString();
					if(bit == 16) {
						//截取32位md5为16位
						String md16 = md5.substring(8, 24).toString();
						md5 = md16;
						if (isUpper)
							md5 = md5.toUpperCase();
						return md5;
					}
				}
				//转换成大写
				if (isUpper)
					md5 = md5.toUpperCase();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("md5加密抛出异常！");
			}
	 
			return md5;
		}
		
		
		public static void main(String[] args) {
			String pwdString= getMD5("1234", true, 32);
			System.out.println(pwdString);
		}

}
