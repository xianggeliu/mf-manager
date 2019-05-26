package com.imf.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by JiXiang on 2019/5/24 22:17
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KdEntity implements Serializable {

    //查询的快递单号
    @JsonProperty(value = "LogisticCode")
    private String logisticCode;

    //查询的账户
    @JsonProperty(value = "EBusinessID")
    private String eBusinessID;

    //返回的状态
    @JsonProperty(value = "Code")
    private String code;

    // 响应是否成功；
    @JsonProperty(value = "Success")
    private boolean  success;

    //返回的物流公司信息
    @JsonProperty(value = "Shippers")
    private List<Shippers> shippers;


    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public String geteBusinessID() {
        return eBusinessID;
    }

    public void seteBusinessID(String eBusinessID) {
        this.eBusinessID = eBusinessID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Shippers> getShippers() {
        return shippers;
    }

    public void setShippers(List<Shippers> shippers) {
        this.shippers = shippers;
    }
}
