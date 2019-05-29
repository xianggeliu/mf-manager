package com.imf.mapper;

import com.imf.pojo.MfExpressDayTotal;
import com.imf.pojo.MfExpressDayTotalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfExpressDayTotalMapper {
    int countByExample(MfExpressDayTotalExample example);

    int deleteByExample(MfExpressDayTotalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MfExpressDayTotal record);

    int insertSelective(MfExpressDayTotal record);

    List<MfExpressDayTotal> selectByExample(MfExpressDayTotalExample example);

    MfExpressDayTotal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MfExpressDayTotal record, @Param("example") MfExpressDayTotalExample example);

    int updateByExample(@Param("record") MfExpressDayTotal record, @Param("example") MfExpressDayTotalExample example);

    int updateByPrimaryKeySelective(MfExpressDayTotal record);

    int updateByPrimaryKey(MfExpressDayTotal record);
}