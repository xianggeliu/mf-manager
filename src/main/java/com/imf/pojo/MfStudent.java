package com.imf.pojo;

import java.util.Date;

public class MfStudent {
    private Integer id;

    private String stuUuid;

    private String stuName;

    private Byte stuAge;

    private Byte stuGender;

    private String stuImgUrl;

    private Date createTime;

    private Date editTime;

    private Boolean stuState;

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
        this.stuUuid = stuUuid == null ? null : stuUuid.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Byte getStuAge() {
        return stuAge;
    }

    public void setStuAge(Byte stuAge) {
        this.stuAge = stuAge;
    }

    public Byte getStuGender() {
        return stuGender;
    }

    public void setStuGender(Byte stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuImgUrl() {
        return stuImgUrl;
    }

    public void setStuImgUrl(String stuImgUrl) {
        this.stuImgUrl = stuImgUrl == null ? null : stuImgUrl.trim();
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

    public Boolean getStuState() {
        return stuState;
    }

    public void setStuState(Boolean stuState) {
        this.stuState = stuState;
    }
}