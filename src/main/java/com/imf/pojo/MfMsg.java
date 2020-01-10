package com.imf.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by JiXiang on 2020/1/9 17:38
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */

@Component
@ConfigurationProperties(prefix = "mf.msg")
@Data
public class MfMsg {

    private String username;

    private String password;

}
