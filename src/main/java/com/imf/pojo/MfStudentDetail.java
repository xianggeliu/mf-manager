package com.imf.pojo;

public class MfStudentDetail {
    private String stuUuid;

    private String stuParentName;

    private String stuAddress;

    private String stuPhoneNum;

    private Integer stuYear;

    private Integer stuMonth;

    private Integer stuDay;

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

    public String getStuPhoneNum() {
        return stuPhoneNum;
    }

    public void setStuPhoneNum(String stuPhoneNum) {
        this.stuPhoneNum = stuPhoneNum == null ? null : stuPhoneNum.trim();
    }

    public Integer getStuYear() {
        return stuYear;
    }

    public void setStuYear(Integer stuYear) {
        this.stuYear = stuYear;
    }

    public Integer getStuMonth() {
        return stuMonth;
    }

    public void setStuMonth(Integer stuMonth) {
        this.stuMonth = stuMonth;
    }

    public Integer getStuDay() {
        return stuDay;
    }

    public void setStuDay(Integer stuDay) {
        this.stuDay = stuDay;
    }
}