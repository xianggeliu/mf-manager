package com.imf.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties
public class MfStudentView implements Serializable {

    private Integer id;

    private String stuUuid;

    private String stuName;

    private Integer stuAge;

    private Integer stuGender;

    private String stuImgUrl;

    private Date createTime;

    private Date editTime;

    private Integer stuState;

    private String stuParentName;

    private String stuAddress;

    private String stuPhoneNum;

    private Integer stuYear;

    private Integer stuMonth;

    private Integer stuDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuUuid() {
        return stuUuid;
    }

    public void setStuUuid(String stuUuid) {
        this.stuUuid = stuUuid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
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

    public String getStuImgUrl() {
        return stuImgUrl;
    }

    public void setStuImgUrl(String stuImgUrl) {
        this.stuImgUrl = stuImgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Integer getStuState() {
        return stuState;
    }

    public void setStuState(Integer stuState) {
        this.stuState = stuState;
    }

    public String getStuParentName() {
        return stuParentName;
    }

    public void setStuParentName(String stuParentName) {
        this.stuParentName = stuParentName;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getStuPhoneNum() {
        return stuPhoneNum;
    }

    public void setStuPhoneNum(String stuPhoneNum) {
        this.stuPhoneNum = stuPhoneNum;
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
