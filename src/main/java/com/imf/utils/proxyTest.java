package com.imf.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class proxyTest {
  public static void main(String[] args) throws Exception {
//   showHttpProxy1();
//      intoDJPersonInfo("");
      int[] numbers = {18,1,32,123,11,8,5,12,89};
      numbers = bubbleSort(numbers);
      System.out.println(numbers);
  }


  public static int[]  bubbleSort(int[] args){
      for (int j = 0; j < args.length; j++) {
          for (int i = 0; i < args.length; i++) {
              int arg = args[i];
              if (i < args.length -1 && arg > args[i + 1]){
                  args[i] = args[i + 1];
                  args[i + 1] = arg;
              }
          }
      }
      return args;
  }



  public static void showHttpProxy1() throws MalformedURLException, IOException, URISyntaxException {
	    System.setProperty("java.net.useSystemProxies", "true");
      List l = ProxySelector.getDefault().select(new URI("http://www.baidu.com/"));

    for (Iterator iter = l.iterator(); iter.hasNext();) {
      Proxy proxy = (Proxy) iter.next();
      System.out.println("proxy hostname : " + proxy.type());
      InetSocketAddress addr = (InetSocketAddress) proxy.address();
      if (addr == null) {
        System.out.println("No Proxy");
      } else {
        System.out.println("proxy hostname : " + addr.getHostName());
        System.out.println("proxy port : " + addr.getPort());
      }
    }

}
  
  

  public static void showHttpProxy2() throws MalformedURLException , IOException {
	    URL url = new URL("http://www.baidu.cn");
	//直接打开连接，但系统会调用刚设置的HTTP代理服务器
	URLConnection conn = url.openConnection();
	Scanner scan = new Scanner(conn.getInputStream());
	//读取远程主机的内容
	while(scan.hasNextLine()){
		   System.out.println(scan.nextLine());
	}

}
    private int bufferSize = 20 * 1024 * 1024;
    public static String intoDJPersonInfo(String filePath) throws  Exception {
        File file = new File("E:/url/Users.txt");
        if (file.isFile() && file.exists()) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
//                InputStreamReader isr = new InputStreamReader(bis,"gb2312");
            InputStreamReader isr = new InputStreamReader(bis, "utf-8");
            BufferedReader br = new BufferedReader(isr, 20 * 1024 * 1024);
            String lineTXT = "";
            int count = 0;
            while ((lineTXT = br.readLine()) != null) {
                List<String> personInfo = Arrays.asList(lineTXT.split(","));
                if (personInfo.size() >= 5  && StringUtils.isNotEmpty(personInfo.get(4))) {
                    String mobile = personInfo.get(4);
                    System.out.println("数量 ：" + count);
                    System.out.println("有手机号的人员信息 ：" + lineTXT);
                    count++;
                }
            }
        }
        return null;
    }
}


