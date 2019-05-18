package com.imf.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class MfStudent {
    private Integer stuUuid;

    private String stuName;

    private Integer stuAge;

    private Integer stuGender;

    private String stuParentName;

    private String stuAddress;

    private Integer stuPhoneNum;

    private String stuImgUrl;

    public Integer getStuUuid() {
        return stuUuid;
    }

    public void setStuUuid(Integer stuUuid) {
        this.stuUuid = stuUuid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public Integer getStuGender() {
        return stuGender;
    }

    public void setStuGender(Integer stuGender) {
        this.stuGender = stuGender;
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

    public String getStuImgUrl() {
        return stuImgUrl;
    }

    public void setStuImgUrl(String stuImgUrl) {
        this.stuImgUrl = stuImgUrl == null ? null : stuImgUrl.trim();
    }
}