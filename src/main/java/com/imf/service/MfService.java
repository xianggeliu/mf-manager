package com.imf.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by JiXiang on 2019/5/19 16:36
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
public interface MfService {
    public String uploadImg(MultipartFile data, String path, Integer type) throws Exception;
}
