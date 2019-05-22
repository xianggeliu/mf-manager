package com.imf.service;

import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfStudent;
import com.imf.utils.Pager;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.util.List;

/**
 * Created by JiXiang on 2019/5/19 16:34
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
public interface StudentService {
    MFJSONResult saveStudentInfo(String imgUrl, String info) throws Exception;

    Pager<MfStudent> getStudentList(Integer pageNum, Integer pageSize, String param);
}
