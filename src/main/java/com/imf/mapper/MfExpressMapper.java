package com.imf.mapper;

import com.imf.pojo.MfExpress;
import com.imf.pojo.MfExpressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfExpressMapper {
    int countByExample(MfExpressExample example);

    int deleteByExample(MfExpressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MfExpress record);

    int insertSelective(MfExpress record);

    List<MfExpress> selectByExample(MfExpressExample example);

    MfExpress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MfExpress record, @Param("example") MfExpressExample example);

    int updateByExample(@Param("record") MfExpress record, @Param("example") MfExpressExample example);

    int updateByPrimaryKeySelective(MfExpress record);

    int updateByPrimaryKey(MfExpress record);

    MfExpress selectByExpressNum(String expressNum);
}