package com.imf.controller;

import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfStudent;
import com.imf.utils.JsonUtils;
import com.imf.utils.MinioUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@ResponseBody
@RequestMapping("/student")
public class StudentController {


    @RequestMapping("/getStudentList")
    public MFJSONResult getStudentList(@RequestParam(value="pageNum", defaultValue="1")Integer pageNum ,
                                       @RequestParam(value="pageSize", defaultValue="10")Integer pageSize , String param){
        //从数据库查询出所有学生的信息，展示到前台页面

        return null;
    }

    @RequestMapping("/studentMananger")
    public String getStudentMananger(){
        return "thymeleaf/mf/MfStudentManagerView";
    }


    @RequestMapping("/updateStudenInfo")
    public String updateStudenInfo(){

        return "thymeleaf/mf/studentEdit";
    }

    @RequestMapping("/setStudentInfo")
    public void upload(@RequestParam MultipartFile data , String mfStudent , final HttpServletResponse response) {
        String fileName = data.getOriginalFilename();
        String lastName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
        String filePath = "test" + "/3"+ lastName;
        String contentType = data.getContentType();
        MfStudent ms = JsonUtils.jsonToPojo(mfStudent , MfStudent.class);

        try {
            InputStream inputStram = data.getInputStream();
//            JSONObject jsonObject = MinioUtil.uploadImage(inputStram, filePath);
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


    @RequestMapping(value = "downPhotoById")
    public void downPhotoByStudentId(String id, final HttpServletResponse response){
//        PhotoEntity entity = this.photoMapper.getPhotoEntityByPhotoId(id);
//        byte[] data = entity.getPhotoData();
//        String fileName = entity.getFileName()== null ? "照片.png" : entity.getFileName();
//        fileName = URLEncoder.encode(fileName, "UTF-8");
//        response.reset();
//        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//        response.addHeader("Content-Length", "" + data.length);
//        response.setContentType("application/octet-stream;charset=UTF-8");
//        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
//        outputStream.write(data);
//        outputStream.flush();
//        outputStream.close();

//        response.addHeader("Content-Disposition","attachment;filename=" + );
//        java.io.OutputStream outp = response.getOutputStream();
//        outp.write(从你的minio得到字节流，然后写入);
//        outp.flush();
    }



    public String setStudentInfo(@RequestParam(value = "upImg") MultipartFile  file ){
        if (!file.isEmpty()){
            try {
                ClassPathResource resource = new ClassPathResource("/static/assets/images");
                String path = resource.getURL().getPath();
                String filename = file.getOriginalFilename();
                File f = new File(path , filename);
                FileOutputStream fil = new FileOutputStream(path + filename)   ;
                IOUtils.copy(file.getInputStream(), fil);
                fil.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{

        }
        return "thymeleaf/mf/studentAdd";
    }


    @RequestMapping("/deleteStudentInfo")
    public String deleteStudentInfo(){

        return "thymeleaf/mf/studentListView1";

    }
}
