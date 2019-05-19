package com.imf.mapper;

import com.imf.pojo.MfStudentDetail;
import com.imf.pojo.MfStudentDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfStudentDetailMapper {
    int countByExample(MfStudentDetailExample example);

    int deleteByExample(MfStudentDetailExample example);

    int deleteByPrimaryKey(String stuUuid);

    int insert(MfStudentDetail record);

    int insertSelective(MfStudentDetail record);

    List<MfStudentDetail> selectByExample(MfStudentDetailExample example);

    MfStudentDetail selectByPrimaryKey(String stuUuid);

    int updateByExampleSelective(@Param("record") MfStudentDetail record, @Param("example") MfStudentDetailExample example);

    int updateByExample(@Param("record") MfStudentDetail record, @Param("example") MfStudentDetailExample example);

    int updateByPrimaryKeySelective(MfStudentDetail record);

    int updateByPrimaryKey(MfStudentDetail record);
}