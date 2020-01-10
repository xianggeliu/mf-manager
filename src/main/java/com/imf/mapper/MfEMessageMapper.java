package com.imf.mapper;

import com.imf.pojo.MfEMessage;
import com.imf.pojo.MfEMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfEMessageMapper {
    int countByExample(MfEMessageExample example);

    int deleteByExample(MfEMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MfEMessage record);

    int insertSelective(MfEMessage record);

    List<MfEMessage> selectByExample(MfEMessageExample example);

    MfEMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MfEMessage record, @Param("example") MfEMessageExample example);

    int updateByExample(@Param("record") MfEMessage record, @Param("example") MfEMessageExample example);

    int updateByPrimaryKeySelective(MfEMessage record);

    int updateByPrimaryKey(MfEMessage record);
}