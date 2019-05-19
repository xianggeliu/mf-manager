package com.imf.utils;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.google.api.client.util.Value;
import com.sun.imageio.plugins.common.ImageUtil;
import io.minio.MinioClient;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MinioUtil {

    @Value("com.imf.minioUrl")
    private static String minio_url;

    @Value("com.imf.minioName")
    private static String minio_name;

    @Value("com.imf.minioPass")
    private static String minio_pass;

    @Value("com.imf.minioBucketName")
    private static String minio_bucketName;

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
    public static JSONObject uploadImages(String imgs, String userId, String type, String path) throws Exception {
        return uploadImgs(imgs, userId, type, path);
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
        MinioClient minioClient = new MinioClient(minio_url, minio_name, minio_pass);
        minioClient.removeObject(minio_bucketName, objectName);
    }


    /**
     * @return
     * @throws Exception
     * @Title: upload
     * @Description:上传主功能
     */
    private static JSONObject upload(InputStream inputStream, String suffix, String contentType) throws Exception {
        JSONObject map = new JSONObject();
        MinioClient minioClient = new MinioClient(minio_url, minio_name, minio_pass);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        String objectName = ymd + "/" + (suffix != null ? suffix : "");
        minioClient.putObject(minio_bucketName, objectName, inputStream, contentType);
//        String bucketPolicy = minioClient.getBucketPolicy(minio_bucketName);
        String url = minioClient.getObjectUrl(minio_bucketName, objectName);
        String urls = minioClient.presignedGetObject(minio_bucketName, objectName, 60 * 60 * 24);
//            System.out.println(url);
//        Iterable<Result<Item>> results = minioClient.listObjects(minio_bucketName, "20189/test/");
        map.put("img", urls);
        map.put("flag", "0");
        map.put("mess", "上传成功");
        map.put("url", url);
        map.put("objectName", objectName);
        map.put("urlval", url);
        map.put("path", minio_bucketName + "/" + objectName);
        return map;
    }


    /**
     * 上传 一张图片
     *
     * @return
     */

    private static String uploadImg(InputStream inputStream, String objectName, String contentType) throws Exception {
        JSONObject map = new JSONObject();
        MinioClient minioClient = new MinioClient(minio_url, minio_name, minio_pass);
        boolean found = minioClient.bucketExists(minio_bucketName);
        //判断当前的bucketName 是否存在，比存在就创建一个
        if (!found) {
            // Create bucket 'my-bucketname'.
            minioClient.makeBucket(minio_bucketName);
        }
        //把图片上传到服务器
        minioClient.putObject(minio_bucketName, objectName, inputStream, contentType);
        //返回上传图片的url地址
//        return  minioClient.presignedGetObject(minio_bucketName, objectName, 60 * 60 * 24);
        return "";
    }


    /**
     * 上传多张图片可以是也可以说是一张
     *
     * @return
     */

    private static JSONObject uploadImgs(String imgs, String userId, String type, String path) throws Exception {
        JSONObject map = new JSONObject();
        //获取配置文件
        //添加minio相关信息
        MinioClient minioClient = new MinioClient(minio_url, minio_name, minio_pass);
        boolean found = minioClient.bucketExists(minio_bucketName);
        //判断当前的bucketName 是否存在，比存在就创建一个
        if (!found) {
            minioClient.makeBucket(minio_bucketName);
        }
        StringBuilder imgUrl = new StringBuilder();
        StringBuilder imgUrlz = new StringBuilder();
        int index = 1;
        File file = new File(path);
        if (!file.exists()) {
            boolean mkdir = file.mkdirs();
        }
        //图片缩略图尺寸
//        int img_s_width = p.getInteger("Img_s_width");
//        int img_s_height = p.getInteger("Img_s_height");
//        //图片裁剪尺寸
//        int img_c_width = p.getInteger("Img_c_width");
//        int img_c_height = p.getInteger("Img_c_height");
//        //裁剪起始位置
//        int img_c_x = p.getInteger("Img_c_x");
//        int img_c_y = p.getInteger("Img_c_y");
        String[] split = imgs.split(",");
        for (String imgurl : split) {
            File tempFile = new File(imgurl);
            //获取图片类型
            String contentType = Files.probeContentType(Paths.get(imgurl));
            //获取图片名称 和后缀名
            String fileName = tempFile.getName();
            String lastName = imgurl.substring(imgurl.lastIndexOf(".")); // 获取文件的后缀
            //把图片上传到服务器
            InputStream is = new FileInputStream(imgurl);
            minioClient.putObject(minio_bucketName, fileName, is, contentType);
            is.close();
            //压缩处理图片
            //把上传的文件转换成file 在本地创建临时文件
            ImageUtil iul = new ImageUtil();
            // 压缩后的文件名称
            //在临时文件里创建缩略图
//            int i = iul.thumbnailImage(tempFile, img_s_width, img_s_height, imgurl, false, lastName);
            // i = 1 是图片处理成功，i= 0 是图片处理不成功 不成功直接使用原图
//            if (i == 0){
//                if (index == 1) {
//                    imgUrl.append(fileName);
//                    imgUrlz.append(fileName);
//                } else {
//                    imgUrl.append(",").append(fileName);
//                    imgUrlz.append(",").append(fileName);
//                }
//                index++;
//                continue;
//            }
            // i = 1 是图片处理成功，i= 0 是图片处理不成功 不成功直接使用原图
            String tempFileName = imgurl.replace(lastName, "z" + lastName);
            //将图片 裁剪 放到项目路径下
            File file2 = new File(file + "/" + 2 + lastName);
//            iul.cutImage(file2, tempFileName, img_c_x, img_c_y, img_c_width, img_c_height);
            //创建临时文件夹
            File z_file = new File(tempFileName);
            //裁剪过的图片 变成输入流
            InputStream fileInputStream = new FileInputStream(tempFileName);
            //压缩图片上传到服务器
            String contentType2 = Files.probeContentType(Paths.get(tempFileName));
            String zFileName = fileName.replace(lastName, "z" + lastName);
            minioClient.putObject(minio_bucketName, zFileName, fileInputStream, contentType2);
            fileInputStream.close();
            if (index == 1) {
                imgUrlz.append(zFileName);
                imgUrl.append(fileName);
            } else {
                imgUrl.append(",").append(fileName);
                imgUrlz.append(",").append(zFileName);
            }
            index++;
        }
        map.put("imgUrl", imgUrl.toString());
        map.put("imgUrlz", imgUrlz.toString());
        //返回上传图片的url地址
        return map;
    }


    /**
     * @return
     * @throws Exception
     * @Title: upload
     * @Description:上传主功能
     */
    private static InputStream download(String objectName) throws Exception {
        MinioClient minioClient = new MinioClient(minio_url, minio_name, minio_pass);
        InputStream inputStream = minioClient.getObject(minio_bucketName, objectName);
        return inputStream;
    }



}
