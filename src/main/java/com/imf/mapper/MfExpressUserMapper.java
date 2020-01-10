package com.imf.mapper;

import com.imf.pojo.MfExpressUser;
import com.imf.pojo.MfExpressUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MfExpressUserMapper {
    int countByExample(MfExpressUserExample example);

    int deleteByExample(MfExpressUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MfExpressUser record);

    int insertSelective(MfExpressUser record);

    List<MfExpressUser> selectByExample(MfExpressUserExample example);

    MfExpressUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MfExpressUser record, @Param("example") MfExpressUserExample example);

    int updateByExample(@Param("record") MfExpressUser record, @Param("example") MfExpressUserExample example);

    int updateByPrimaryKeySelective(MfExpressUser record);

    int updateByPrimaryKey(MfExpressUser record);

    /**
     * 通过手机号获取用户信息
     * @param phone
     * @return
     */
    MfExpressUser selectByMobile(String phone);
}