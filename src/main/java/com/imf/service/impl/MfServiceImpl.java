package com.imf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.imf.service.MfService;
import com.imf.utils.MinioUtil;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by JiXiang on 2019/5/19 16:41
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
public class MfServiceImpl implements MfService {
    private static final Logger logger = Logger.getLogger(MfServiceImpl.class);

    /**
     * 上传图片方法
     *
     * @param data
     * @param path
     * @param type
     * @return
     */
    @Override
    public String uploadImg(MultipartFile data, String path, Integer type) throws Exception {
        //获取文件名称截取后缀名重新命名
        String fileName = data.getOriginalFilename();
        String lastName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
        //拼接新的名称
        StringBuilder imgsb = new StringBuilder(path);
        if (type == 1) {
            imgsb.append("/teacher/");
        } else {
            imgsb.append("/student/");
        }
        imgsb.append(System.currentTimeMillis()).append(lastName);
        String newImgFile = imgsb.toString();
        data.transferTo(new File(newImgFile));
        JSONObject jsonObject;
        jsonObject = MinioUtil.uploadImages(newImgFile, "");
        return jsonObject == null ? "" : jsonObject.getString("imgUrlz");
    }
}
