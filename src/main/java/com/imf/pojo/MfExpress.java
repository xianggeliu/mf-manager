package com.imf.pojo;

public class MfExpress {
    private Integer id;

    private String expressNumber;

    private String eCompany;

    private Integer eCompanyCode;

    private Long enteringTime;

    private Long getTime;

    private Long ePhone;

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

    public Long getEnteringTime() {
        return enteringTime;
    }

    public void setEnteringTime(Long enteringTime) {
        this.enteringTime = enteringTime;
    }

    public Long getGetTime() {
        return getTime;
    }

    public void setGetTime(Long getTime) {
        this.getTime = getTime;
    }

    public Long getePhone() {
        return ePhone;
    }

    public void setePhone(Long ePhone) {
        this.ePhone = ePhone;
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