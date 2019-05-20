package com.imf.service.impl;

import com.imf.mapper.*;
import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfStudent;
import com.imf.pojo.MfStudentDetail;
import com.imf.pojo.MfStudentView;
import com.imf.service.StudentService;
import com.imf.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiXiang on 2019/5/19 16:40
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */

@Service
public class StudentServiceImpl implements StudentService {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TeacherServiceImpl.class);

    @Autowired
    private MfStudentMapper studentMapper;

    @Autowired
    private MfStudentDetailMapper studentDetailMapper;

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public MFJSONResult saveStudentInfo(String imgUrl, String info) throws JSONException {
        //把json转换成map
        MfStudentView mfStudentView = JsonUtils.jsonToPojo(info , MfStudentView.class);
        //获取学生ID
        String studentId = "S" + userLoginMapper.selectSequence("student");
        //封装学生基本信息
        MfStudent student = new MfStudent();
        student.setStuUuid(studentId);
        student.setStuName(mfStudentView.getStuName());
        student.setStuAge(mfStudentView.getStuAge());
        student.setStuGender(mfStudentView.getStuGender());
        student.setStuImgUrl(imgUrl);
        student.setStuState(1);
        student.setCreateTime(new Date());
        int state = studentMapper.insert(student);
        if (state == 1){
            //封装学生详细信息
            MfStudentDetail studentDetail = new MfStudentDetail();
            studentDetail.setStuUuid(studentId);
            studentDetail.setStuAddress(mfStudentView.getStuAddress());
            studentDetail.setStuParentName(mfStudentView.getStuParentName());
            studentDetail.setStuPhoneNum(mfStudentView.getStuPhoneNum());
            int insertState = studentDetailMapper.insert(studentDetail);
            if (insertState == 1){
                return MFJSONResult.ok();
            }
        }
        return MFJSONResult.errorMsg("添加学生信息失败！");
    }
}
