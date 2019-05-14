package com.imf.mapper;

import java.util.List;

import com.imf.pojo.SysUser;

public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}