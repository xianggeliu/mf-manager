package com.imf.mapper;

import com.imf.pojo.MfECompany;
import com.imf.pojo.MfECompanyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfECompanyMapper {
    int countByExample(MfECompanyExample example);

    int deleteByExample(MfECompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MfECompany record);

    int insertSelective(MfECompany record);

    List<MfECompany> selectByExample(MfECompanyExample example);

    MfECompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MfECompany record, @Param("example") MfECompanyExample example);

    int updateByExample(@Param("record") MfECompany record, @Param("example") MfECompanyExample example);

    int updateByPrimaryKeySelective(MfECompany record);

    int updateByPrimaryKey(MfECompany record);

    MfECompany selectByCompanyName(String companyName);
}