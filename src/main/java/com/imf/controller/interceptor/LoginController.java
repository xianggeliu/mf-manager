package com.imf.controller.interceptor;

import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfExpress;
import com.imf.service.ExpressService;
import com.imf.service.LoginService;
import com.imf.utils.ExampleAll;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private ExpressService expressService;

    @RequestMapping("/index")
    public String login() {
        return "thymeleaf/mf/index";
    }

    @RequestMapping("/reg")
    public String reg() {
        return "thymeleaf/mf/reg";
    }

    @RequestMapping("/getpass")
    public String getpass() {
        return "thymeleaf/mf/getpass";
    }

    @RequestMapping("/express")
    public String express() {
        return "thymeleaf/mf/expressage/express";
    }

    @RequestMapping("/expressInto")
    public String expressInto() {
        return "thymeleaf/mf/expressage/expressInto";
    }

    @RequestMapping("/expressOut")
    public String expressOut() {
        return "thymeleaf/mf/expressage/expressOut";
    }

    @RequestMapping("/expressSearch")
    public String expressSearch() {
        return "thymeleaf/mf/expressage/expressSearch";
    }

    @RequestMapping("/expressShow")
    public String expressShow() {
        return "thymeleaf/mf/expressage/expressShow";
    }
    @RequestMapping("/setting")
    public String exoressSetting() {
        return "thymeleaf/mf/expressage/setting";
    }

    @RequestMapping("/expressDayTotal")
    public String expressDayTotal() {
        return "thymeleaf/mf/expressage/expressDayTotal";
    }

    @RequestMapping("/ipAddress")
    public String ipAddress() {
        return "thymeleaf/mf/url";
    }

    @RequestMapping("/isProxy")
    @ResponseBody
    public Object isProxy(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if(org.apache.commons.lang.StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                ip = ip.substring(0,index);
            }
        }
        if(org.apache.commons.lang.StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            ip = request.getHeader("X-Real-IP");
        }

        if(org.apache.commons.lang.StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(org.apache.commons.lang.StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
        String remoteIp = request.getRemoteAddr();

        if ( ip != null && !ip.equals(remoteIp)){
            return "true";
        }else{
            return "false";
        }

//        return map;
    }

    @RequestMapping("/postExpress")
    @ResponseBody
    public MFJSONResult postExpress(@RequestParam(value = "expressNum") String expressNum, @RequestParam(value = "companyCode") String companyCode, String phone , String name) {
        try {
            return expressService.insertExpressInfo(expressNum, companyCode, phone, name , 1);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加快递信息异常，请重试！");
        }

    }

    @RequestMapping("/getExpressInfo")
    @ResponseBody
    public MFJSONResult getExpressInfo(@RequestParam(value = "expressNum") String expressNum) {
        try {
            return expressService.getExpressInfo(expressNum);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("获取快递信息异常，请重试！");
        }

    }

    @RequestMapping("/takesExpress")
    @ResponseBody
    public MFJSONResult takesExpress(@RequestParam(value = "expressNum") String expressNum) {
        try {
            return expressService.takesExpress(expressNum);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加快递信息异常，请重试！");
        }

    }

    @RequestMapping("/getExpress")
    @ResponseBody
    public MFJSONResult getExpress(@RequestParam(value = "expressNum") String expressNum) {
        try {
            return expressService.getExpress(expressNum);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加快递信息异常，请重试！");
        }

    }

    @RequestMapping("/saveExpressTotal")
    @ResponseBody
    public MFJSONResult saveExpressTotal(int state) {
        try {
            return expressService.saveExpressInTotal(state);
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加快递信息异常，请重试！");
        }

    }

    @RequestMapping("/redirctUrl")
    public void redirctUrl(HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        try {
            response.sendRedirect("https://www.baidu.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/postTest")
    public void redirctUrl(RedirectAttributes attributes){
        try {
        String ssoSessionData =  ExampleAll.getSSOSessionData("99999901", "CMUONLINE@HQ.CMCC");
		System.out.println("获取的数据 ：" +ssoSessionData);
        } catch (Exception e) {
            System.out.println("SMAP测试失败！");
            e.printStackTrace();
        }
    }


    @RequestMapping("/dologin")

    public ModelAndView loginView(String username, String password, HttpServletResponse response) {
        try {
            MFJSONResult mfjsonResult = loginService.doLogin(username, password, response);
            if (mfjsonResult.getStatus() == 200) {
                ModelAndView mv = new ModelAndView();

                //手动显式指定使用转发，此时springmvc.xml配置文件中的视图解析器将会失效
                mv.setViewName("forward:/mf/view");
                return mv;
//                return "redirect:/mf/view";
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("login/dologin 登录方法失败" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static String post(String url,Map<String,Object> parameterMap) {

        Date interfaceindate=new Date();
        String starttime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(interfaceindate);
        logger.info("接口请求方法进入：interfaceintime:"+starttime+",url:"+url);
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        //设置请求头以及连接失效时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(30000)
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(30000)
                .build();
        httppost.setConfig(requestConfig);
        httppost.setHeader("Content-type", "application/json;charset=UTF-8");
        // 创建参数队列
//        if (parameterMap == null) return null;
//        String para = JsonHelper.toJson(parameterMap);
        String req = "";
        String data = null;
        StringEntity jsonEntity;
        ContentType contentType = ContentType.create("application/json","UTF-8");
        try {
            logger.info(String.format("【请求接口】:%s",url));
//            logger.info(String.format("【请求参数】:%s",para));
            Map<String,String> temp = new HashMap<String,String>();
            temp.put("secret",req);
//            jsonEntity = new StringEntity(JsonHelper.toJson(temp),contentType);
//            httppost.setEntity(jsonEntity);

            Date interfacestartrequestdate=new Date();
            String interfacestartrequesttime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(interfacestartrequestdate);
            logger.info("接口开始请求：interfacestartrequesttime:"+interfacestartrequesttime+",url:"+url);


            CloseableHttpResponse response = httpclient.execute(httppost);


            Date interfaceendrequestdate=new Date();
            String interfaceendrequesttime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(interfaceendrequestdate);

            long mseconds =interfaceendrequestdate.getTime()-interfacestartrequestdate.getTime();

            logger.info("接口请求返回：interfacestartrequesttime:"+interfaceendrequesttime+",耗时："+mseconds+"  millisecond,url:"+url);


            try {
                HttpEntity entity = response.getEntity();
                data = EntityUtils.toString(entity, "UTF-8");
                logger.info(String.format("【接口调用返回结果】响应:%s",data));

            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            logger.error("接口请求方法异常：url:"+url, e);
        } catch (UnsupportedEncodingException e1) {
            logger.error("接口请求方法异常：url:"+url, e1);
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("接口请求方法异常：url:"+url, e);
        } catch(Exception e){
            e.printStackTrace();
            logger.error("接口请求方法异常：url:"+url, e);
        }finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Date enddate=new Date();
        String endtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(enddate);
        logger.info("接口请求方法出：endtime:"+endtime+",url:"+url);
        long milseconds =enddate.getTime()-interfaceindate.getTime();
        logger.info("接口请求方法出：passtime:"+milseconds+" millisecond ,url:"+url);
        return data;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

}
