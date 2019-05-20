package com.imf.service.impl;

import com.imf.mapper.MfTeacherDetailMapper;
import com.imf.mapper.MfTeacherMapper;
import com.imf.mapper.UserLoginMapper;
import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfTeacher;
import com.imf.pojo.MfTeacherDetail;
import com.imf.service.TeacherService;
import com.imf.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * Created by JiXiang on 2019/5/19 16:41
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TeacherServiceImpl.class);

    @Autowired
    private MfTeacherMapper mfTeacherMapper;

    @Autowired
    private MfTeacherDetailMapper mfTeacherDetailMapper;

    @Autowired
    private UserLoginMapper userLoginMapper;
    @Override
    public MFJSONResult saveTeachInfo(String imgUrl, String info) {
        //把json串转换成Map
        HashMap<String , String > map = JsonUtils.jsonToPojo(info, HashMap.class);
        //生成teacher Id
        String teacherId = "T" + userLoginMapper.selectSequence("teacher");
        //封装其他相关信息 封装teacher表的数据，
        MfTeacher mfTeacher = new MfTeacher();
        MfTeacherDetail mfTeacherDetail = new MfTeacherDetail();
        //封装基本信息
        mfTeacher.setTeachId(teacherId);
        mfTeacher.setTeachName(map.get("tName"));
        mfTeacher.setTeachAge(Integer.parseInt(map.get("tAge")));
        mfTeacher.setTeachGender(Integer.parseInt(map.get("tGender")));
        //全部保存成功后返回数据添加成功；

        return null;
    }
}
