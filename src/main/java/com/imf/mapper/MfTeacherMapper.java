package com.imf.mapper;

import com.imf.pojo.MfTeacher;
import com.imf.pojo.MfTeacherExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfTeacherMapper {
    int countByExample(MfTeacherExample example);

    int deleteByExample(MfTeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MfTeacher record);

    int insertSelective(MfTeacher record);

    List<MfTeacher> selectByExample(MfTeacherExample example);

    MfTeacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MfTeacher record, @Param("example") MfTeacherExample example);

    int updateByExample(@Param("record") MfTeacher record, @Param("example") MfTeacherExample example);

    int updateByPrimaryKeySelective(MfTeacher record);

    int updateByPrimaryKey(MfTeacher record);
}