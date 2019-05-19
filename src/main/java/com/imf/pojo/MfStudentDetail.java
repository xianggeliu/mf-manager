package com.imf.pojo;

public class MfStudentDetail {
    private String stuUuid;

    private String stuParentName;

    private String stuAddress;

    private Integer stuPhoneNum;

    public String getStuUuid() {
        return stuUuid;
    }

    public void setStuUuid(String stuUuid) {
        this.stuUuid = stuUuid == null ? null : stuUuid.trim();
    }

    public String getStuParentName() {
        return stuParentName;
    }

    public void setStuParentName(String stuParentName) {
        this.stuParentName = stuParentName == null ? null : stuParentName.trim();
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress == null ? null : stuAddress.trim();
    }

    public Integer getStuPhoneNum() {
        return stuPhoneNum;
    }

    public void setStuPhoneNum(Integer stuPhoneNum) {
        this.stuPhoneNum = stuPhoneNum;
    }
}