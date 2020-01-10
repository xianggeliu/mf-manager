package com.imf.controller;


import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfStudent;
import com.imf.service.MfService;
import com.imf.service.StudentService;
import com.imf.service.TeacherService;
import com.imf.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public String getStudentMananger() {
        return "thymeleaf/mf/MfIndex";
    }

    @RequestMapping("/studentManagerView")
    public String getStudentView() {
        return "thymeleaf/mf/MfIndex";
    }

    @RequestMapping("/getStudentList")
    public String getStudentList(){
        return "thymeleaf/mf/studentListView";
    }

    @RequestMapping("/redirctUrl")
    public String redirctUrl(){
        ModelAndView mav = new ModelAndView();
        return "redirct:https://www.baidu.com/";
    }


    @RequestMapping("/saveInformation")
    @ResponseBody
    public MFJSONResult upload(@RequestParam MultipartFile data, String personInfo, Integer type, HttpServletRequest request) {

        String typeName = "";
        String uploadDir = "";
        try {
            long start = System.currentTimeMillis();
            uploadDir = ResourceUtils.getURL("classpath:").getPath() + "static/" + start;
            //上传图片到图片服务器
            String imgUrl = mfService.uploadImg(data, uploadDir, type);
            if (StringUtils.isEmpty(imgUrl)) {
                return MFJSONResult.errorMsg("上传图片失败，请重试或者联系管理员！");
            }
            //判断当前是添加的什么信息 1 是老师  2是学生 3 是其他
            if (type == 1) {
                typeName = "老师";
                return teacherService.saveTeachInfo(imgUrl, personInfo);
            } else if (type == 2) {
                typeName = "学生";
                return studentService.saveStudentInfo(imgUrl, personInfo);
            } else {
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
            CommonUtil.delFolder(uploadDir);
            e.printStackTrace();
            return MFJSONResult.errorMsg("添加" + typeName + "信息失败！");
        }


    }
}
