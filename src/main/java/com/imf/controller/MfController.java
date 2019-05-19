package com.imf.controller;


import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfStudent;
import com.imf.service.MfService;
import com.imf.service.StudentService;
import com.imf.service.TeacherService;
import com.imf.utils.JsonUtils;
import com.imf.utils.MinioUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
    private static final Logger logger = Logger.getLogger(MfController.class);



    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private MfService mfService;

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
    public MFJSONResult upload(@RequestParam MultipartFile data , String info , Integer type , final HttpServletResponse response) {
        String fileName = data.getOriginalFilename();
        String lastName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
        String filePath = "test" + "/3"+ lastName;
        String contentType = data.getContentType();
//        MfStudent ms = JsonUtils.jsonToPojo(mfStudent , MfStudent.class);
        String typeName = "";
        try {
            //上传图片到图片服务器
            //
            //
            String imgUrl = mfService.uploadImg(data);
            if (StringUtils.isEmpty(imgUrl)){
                return MFJSONResult.errorMsg("上传图片失败，请重试或者联系管理员！");
            }
            //判断当前是添加的什么信息 1 是老师  2是学生 3 是其他
            if (type == 1){
                typeName = "老师";
                return teacherService.saveTeachInfo(imgUrl ,info );
            }else if (type == 2){
                typeName = "学生";
                return studentService.saveStudentInfo(imgUrl , info);
            }else{
                return MFJSONResult.errorMsg("上传的类型不存在！");
            }
//            InputStream inputStram = data.getInputStream();
//            JSONObject jsonObject = MinioUtil.uploadImage(inputStram, filePath);
//            InputStream img = (InputStream) jsonObject.get("img");
//            byte[] datas = new byte[img.available()];
//            response.addHeader("Content-Disposition","attachment;filename=" + filePath);
//        java.io.OutputStream outp = response.getOutputStream();
//        outp.write(datas);
//        outp.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加" + typeName + "信息失败！");
        }


    }
}
