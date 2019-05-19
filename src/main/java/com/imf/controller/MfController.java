package com.imf.controller;


import com.imf.pojo.MfStudent;
import com.imf.utils.JsonUtils;
import com.imf.utils.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Created by JiXiang on 2019/5/17 17:16
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
@Controller
@RequestMapping("/mf")
public class MfController {

//    @Autowired
//    private
    @RequestMapping("/view")
    public String getStudentMananger(){
        return "thymeleaf/mf/MfIndex";
    }

    @RequestMapping("/studentManagerView")
    public String getStudentList(){
        return "thymeleaf/mf/MfIndex";
    }


    @RequestMapping("/saveInformation")
    @ResponseBody
    public void upload(@RequestParam MultipartFile data , String mfStudent , Integer type ,final HttpServletResponse response) {
        String fileName = data.getOriginalFilename();
        String lastName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
        String filePath = "test" + "/3"+ lastName;
        String contentType = data.getContentType();
        MfStudent ms = JsonUtils.jsonToPojo(mfStudent , MfStudent.class);

        try {
            InputStream inputStram = data.getInputStream();
            JSONObject jsonObject = MinioUtil.uploadImage(inputStram, filePath);
//            InputStream img = (InputStream) jsonObject.get("img");
//            byte[] datas = new byte[img.available()];
//            response.addHeader("Content-Disposition","attachment;filename=" + filePath);
//        java.io.OutputStream outp = response.getOutputStream();
//        outp.write(datas);
//        outp.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
