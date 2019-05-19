package com.imf.mapper;

import com.imf.pojo.MfStudent;
import com.imf.pojo.MfStudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfStudentMapper {
    int countByExample(MfStudentExample example);

    int deleteByExample(MfStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MfStudent record);

    int insertSelective(MfStudent record);

    List<MfStudent> selectByExample(MfStudentExample example);

    MfStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MfStudent record, @Param("example") MfStudentExample example);

    int updateByExample(@Param("record") MfStudent record, @Param("example") MfStudentExample example);

    int updateByPrimaryKeySelective(MfStudent record);

    int updateByPrimaryKey(MfStudent record);
}