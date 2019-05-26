package com.imf.pojo;

public class MfECompany {
    private Integer id;

    private String eCompanyName;

    private String eCompanyCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteCompanyName() {
        return eCompanyName;
    }

    public void seteCompanyName(String eCompanyName) {
        this.eCompanyName = eCompanyName == null ? null : eCompanyName.trim();
    }

    public String geteCompanyCode() {
        return eCompanyCode;
    }

    public void seteCompanyCode(String eCompanyCode) {
        this.eCompanyCode = eCompanyCode == null ? null : eCompanyCode.trim();
    }
}