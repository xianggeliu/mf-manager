package com.imf.utils;

import com.alibaba.druid.util.StringUtils;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MinioUtil {


    private static String minio_url;


    private static String minio_name;


    private static String minio_pass;


    private static String minio_bucketName;


    /**
     *
     * @Title: uploadImage
     * @Description:上传图片
     * @param inputStream
     * @param suffix
     * @return
     * @throws Exception
     */
    public static JSONObject uploadImage(InputStream inputStream, String suffix) throws Exception {
        return upload(inputStream, suffix, "image/jpeg");
    }


    /**
     * @Title: uploadVideo
     * @Description:上传视频
     * @param inputStream
     * @param suffix
     * @return
     * @throws Exception
     */
    public static JSONObject uploadVideo(InputStream inputStream, String suffix) throws Exception {
        return upload(inputStream, suffix, "video/mp4");
    }


    /**
     * @Title: uploadVideo
     * @Description:上传文件
     * @param inputStream
     * @param suffix
     * @return
     * @throws Exception
     */
    public static JSONObject uploadFile(InputStream inputStream, String suffix) throws Exception {
        return upload(inputStream, suffix, "application/octet-stream");
    }


    /**
     * 上传字符串大文本内容
     *
     * @Title: uploadString
     * @Description:描述方法
     * @param str
     * @return
     * @throws Exception
     */
    public static JSONObject uploadString(String str) throws Exception {
        if (!StringUtils.isEmpty(str)) {
            return new JSONObject();
        }
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        return upload(inputStream, null, "text/html");
    }


    /**
     * @Title: upload
     * @Description:上传主功能
     * @return
     * @throws Exception
     */
    private static JSONObject upload(InputStream inputStream, String suffix, String contentType) throws Exception {
        JSONObject map = new JSONObject();
//        PropertiesLoader p = new PropertiesLoader("system.properties");
//        minio_url = p.getProperty("minio_url");
//        minio_name = p.getProperty("minio_name");
//        minio_pass = p.getProperty("minio_pass");
//        minio_bucketName = p.getProperty("minio_bucketName");
        minio_url = "http://169.254.88.204:9000";
        minio_name = "3H1IZWHJPL66YER5Q5D6";
        minio_pass = "6erkeI65W0XqG25hbhWdCpb1ezkoVowF3nW2rxpV";
        minio_bucketName = "cmcc";
        MinioClient minioClient = new MinioClient(minio_url, minio_name, minio_pass);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String ymd = sdf.format(new Date());
        String objectName = ymd + "/"+ (suffix != null ? suffix : "");
        minioClient.putObject(minio_bucketName, objectName, inputStream, contentType);
//        minioClient.
        String bucketPolicy = minioClient.getBucketPolicy(minio_bucketName);
        String url = minioClient.getObjectUrl(minio_bucketName, objectName);
        Iterable<Result<Item>> results = minioClient.listObjects(minio_bucketName, "20189/test/");
//        map.put("img" ,object);
        map.put("flag", "0");
        map.put("mess", "上传成功");
        map.put("url", url);
        map.put("urlval", url);
        map.put("path", minio_bucketName + "/" + objectName);
        return map;
    }

}
