package com.imf.pojo;

import java.util.Date;

public class MfExpress {
    private Integer id;

    private String expressNumber;

    private String eCompany;

    private Integer eCompanyCode;

    private Date enteringTime;

    private String ePhone;

    private Date getTime;

    private String eName;

    private Integer eMark;

    private Integer eState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber == null ? null : expressNumber.trim();
    }

    public String geteCompany() {
        return eCompany;
    }

    public void seteCompany(String eCompany) {
        this.eCompany = eCompany == null ? null : eCompany.trim();
    }

    public Integer geteCompanyCode() {
        return eCompanyCode;
    }

    public void seteCompanyCode(Integer eCompanyCode) {
        this.eCompanyCode = eCompanyCode;
    }

    public Date getEnteringTime() {
        return enteringTime;
    }

    public void setEnteringTime(Date enteringTime) {
        this.enteringTime = enteringTime;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone == null ? null : ePhone.trim();
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public Integer geteMark() {
        return eMark;
    }

    public void seteMark(Integer eMark) {
        this.eMark = eMark;
    }

    public Integer geteState() {
        return eState;
    }

    public void seteState(Integer eState) {
        this.eState = eState;
    }
}