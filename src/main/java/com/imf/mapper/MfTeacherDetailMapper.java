package com.imf.mapper;

import com.imf.pojo.MfTeacherDetail;
import com.imf.pojo.MfTeacherDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfTeacherDetailMapper {
    int countByExample(MfTeacherDetailExample example);

    int deleteByExample(MfTeacherDetailExample example);

    int deleteByPrimaryKey(String teachId);

    int insert(MfTeacherDetail record);

    int insertSelective(MfTeacherDetail record);

    List<MfTeacherDetail> selectByExample(MfTeacherDetailExample example);

    MfTeacherDetail selectByPrimaryKey(String teachId);

    int updateByExampleSelective(@Param("record") MfTeacherDetail record, @Param("example") MfTeacherDetailExample example);

    int updateByExample(@Param("record") MfTeacherDetail record, @Param("example") MfTeacherDetailExample example);

    int updateByPrimaryKeySelective(MfTeacherDetail record);

    int updateByPrimaryKey(MfTeacherDetail record);
}