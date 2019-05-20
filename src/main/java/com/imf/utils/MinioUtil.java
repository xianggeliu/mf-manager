package com.imf.utils;

import com.alibaba.druid.util.StringUtils;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MinioUtil {
    @Autowired
    private static CommonVariable commonVariable;

    private static String minioUrl;

    private static String minioName;

    private static String minioPass;

    private static String minioBucketName;

    private static Integer imgWidth;

    private static Integer imgheight;

    @Value("${com.imf.minio.url}")
    public void setMinioUrl(String minioUrl) {
        MinioUtil.minioUrl = minioUrl;
    }

    @Value("${com.imf.minio.name}")
    public void setMinioName(String minioName) {
        MinioUtil.minioName = minioName;
    }

    @Value("${com.imf.minio.pass}")
    public void setMinioPass(String minioPass) {
        MinioUtil.minioPass = minioPass;
    }

    @Value("${com.imf.minio.bucketName}")
    public void setMinioBucketName(String minioBucketName) {
        MinioUtil.minioBucketName = minioBucketName;
    }

    @Value("${com.imf.imgWidth}")
    public void setImgWidth(Integer imgWidth) {
        MinioUtil.imgWidth = imgWidth;
    }

    @Value("${com.imf.imgheight}")
    public void setImgheight(Integer imgheight) {
        MinioUtil.imgheight = imgheight;
    }


    /**
     * @param inputStream
     * @param objectName
     * @return
     * @throws Exception
     * @Title: uploadImage
     * @Description:上传图片
     */
    public static String uploadImage(InputStream inputStream, String objectName, String contentType) throws Exception {
        return uploadImg(inputStream, objectName, contentType);
    }

    /**
     * @return
     * @throws Exception
     * @Title: uploadImage
     * @Description:上传图片
     */
    public static JSONObject uploadImages(String imgUrl, String contentType, String path, Integer type) throws Exception {
        return uploadImgs(imgUrl, contentType, path, type);
    }


    /**
     * @param inputStream
     * @param suffix
     * @return
     * @throws Exception
     * @Title: uploadVideo
     * @Description:上传视频
     */
    public static JSONObject uploadVideo(InputStream inputStream, String suffix) throws Exception {
        return upload(inputStream, suffix, "video/mp4");
    }


    /**
     * @param inputStream
     * @param suffix
     * @return
     * @throws Exception
     * @Title: uploadVideo
     * @Description:上传文件
     */
    public static JSONObject uploadFile(InputStream inputStream, String suffix) throws Exception {
        return upload(inputStream, suffix, "application/octet-stream");
    }


    /**
     * @return
     * @throws Exception
     * @Title: uploadVideo
     * @Description:下载文件
     */
    public static InputStream downloadImg(String objectName) throws Exception {
        return download(objectName);
    }


    /**
     * 上传字符串大文本内容
     *
     * @param str
     * @return
     * @throws Exception
     * @Title: uploadString
     * @Description:描述方法
     */
    public static JSONObject uploadString(String str) throws Exception {
        if (!StringUtils.isEmpty(str)) {
            return new JSONObject();
        }
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        return upload(inputStream, null, "text/html");
    }

    /**
     * 删除图片
     *
     * @param objectName
     * @return
     * @throws Exception
     */
    public static void deleteImg(String objectName) throws Exception {
        //获取相关minio 相关配置信息
        MinioClient minioClient = new MinioClient(minioUrl, minioName, minioPass);
        minioClient.removeObject(minioBucketName, objectName);
    }


    /**
     * @return
     * @throws Exception
     * @Title: upload
     * @Description:上传主功能
     */
    private static JSONObject upload(InputStream inputStream, String suffix, String contentType) throws Exception {
        JSONObject map = new JSONObject();
        MinioClient minioClient = new MinioClient(minioUrl, minioName, minioPass);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        String objectName = ymd + "/" + (suffix != null ? suffix : "");
        minioClient.putObject(minioBucketName, objectName, inputStream, contentType);
//        String bucketPolicy = minioClient.getBucketPolicy(minioBucketName);
        String url = minioClient.getObjectUrl(minioBucketName, objectName);
        String urls = minioClient.presignedGetObject(minioBucketName, objectName, 60 * 60 * 24);
//            System.out.println(url);
//        Iterable<Result<Item>> results = minioClient.listObjects(minioBucketName, "20189/test/");
        map.put("img", urls);
        map.put("flag", "0");
        map.put("mess", "上传成功");
        map.put("url", url);
        map.put("objectName", objectName);
        map.put("urlval", url);
        map.put("path", minioBucketName + "/" + objectName);
        return map;
    }


    /**
     * 上传 一张图片
     *
     * @return
     */

    private static String uploadImg(InputStream inputStream, String objectName, String contentType) throws Exception {
        JSONObject map = new JSONObject();
        MinioClient minioClient = new MinioClient(minioUrl, minioName, minioPass);
        boolean found = minioClient.bucketExists(minioBucketName);
        //判断当前的bucketName 是否存在，比存在就创建一个
        if (!found) {
            // Create bucket 'my-bucketname'.
            minioClient.makeBucket(minioBucketName);
        }
        //把图片上传到服务器
        minioClient.putObject(minioBucketName, objectName, inputStream, contentType);
        //返回上传图片的url地址
//        return  minioClient.presignedGetObject(minioBucketName, objectName, 60 * 60 * 24);
        return "";
    }


    /**
     * 上传多张图片可以是也可以说是一张
     *
     * @return
     */

    private static JSONObject uploadImgs(String imgurl, String contentType, String path, Integer type) throws Exception {
        JSONObject map = new JSONObject();
        //获取配置文件
        //添加minio相关信息
        MinioClient minioClient = new MinioClient(minioUrl, minioName, minioPass);
        boolean found = minioClient.bucketExists(minioBucketName);
        //判断当前的bucketName 是否存在，比存在就创建一个
        if (!found) {
            minioClient.makeBucket(minioBucketName);
        }
        //图片缩略图尺寸
        File tempFile = new File(imgurl);
        //获取图片类型
//        String contentType = Files.probeContentType(Paths.get(imgurl));
        //获取图片名称 和后缀名
        String fileName = "";
        if (type == 1) {
            fileName = "teacher/" + tempFile.getName();
        } else if (type == 2) {
            fileName = "student/" + tempFile.getName();
        } else {
            fileName = "temp/" + tempFile.getName();
        }
        String lastName = imgurl.substring(imgurl.lastIndexOf(".")); // 获取文件的后缀
        //把图片上传到服务器
        InputStream is = new FileInputStream(imgurl);
        minioClient.putObject(minioBucketName, fileName, is, contentType);
        is.close();
        //压缩处理图片
        //把上传的文件转换成file 在本地创建临时文件
        ImageUtil iul = new ImageUtil();
        // 压缩后的文件名称
        //在临时文件里创建缩略图
        int i = iul.thumbnailImage(tempFile, imgWidth, imgheight, imgurl, false, lastName);
        // i = 1 是图片处理成功，i= 0 是图片处理不成功 不成功直接使用原图
        // i = 1 是图片处理成功，i= 0 是图片处理不成功 不成功直接使用原图
        String tempFileName = fileName.replace(lastName, "z" + lastName);
        //将图片 裁剪 放到项目路径下
        File newFIle = new File(path + "/" + 2 + lastName);
        if (newFIle.exists()) {
            InputStream fileInputStream = new FileInputStream(path + "/" + 2 + lastName);
            //压缩图片上传到服务器
            minioClient.putObject(minioBucketName, tempFileName, fileInputStream, contentType);
            fileInputStream.close();
        }

        //返回上传图片的url地址
        map.put("imgUrl", fileName);
        map.put("imgUrlz", tempFileName);
        return map;
    }

    /**
     * @return
     * @throws Exception
     * @Title: upload
     * @Description:上传主功能
     */
    private static InputStream download(String objectName) throws Exception {
        MinioClient minioClient = new MinioClient(minioUrl, minioName, minioPass);
        InputStream inputStream = minioClient.getObject(minioBucketName, objectName);
        return inputStream;
    }


}
