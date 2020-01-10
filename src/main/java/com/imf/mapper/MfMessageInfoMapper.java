package com.imf.mapper;

import com.imf.pojo.MfMessageInfo;
import com.imf.pojo.MfMessageInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfMessageInfoMapper {
    int countByExample(MfMessageInfoExample example);

    int deleteByExample(MfMessageInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MfMessageInfo record);

    int insertSelective(MfMessageInfo record);

    List<MfMessageInfo> selectByExample(MfMessageInfoExample example);

    MfMessageInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MfMessageInfo record, @Param("example") MfMessageInfoExample example);

    int updateByExample(@Param("record") MfMessageInfo record, @Param("example") MfMessageInfoExample example);

    int updateByPrimaryKeySelective(MfMessageInfo record);

    int updateByPrimaryKey(MfMessageInfo record);
}