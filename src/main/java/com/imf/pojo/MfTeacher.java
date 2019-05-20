package com.imf.pojo;

import java.util.Date;

public class MfTeacher {
    private Integer id;

    private String teachId;

    private String teachName;

    private Integer teachGender;

    private String teachImgUrl;

    private Integer teachAge;

    private Date createTime;

    private Date editTime;

    private Integer teachState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeachId() {
        return teachId;
    }

    public void setTeachId(String teachId) {
        this.teachId = teachId == null ? null : teachId.trim();
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName == null ? null : teachName.trim();
    }

    public Integer getTeachGender() {
        return teachGender;
    }

    public void setTeachGender(Integer teachGender) {
        this.teachGender = teachGender;
    }

    public String getTeachImgUrl() {
        return teachImgUrl;
    }

    public void setTeachImgUrl(String teachImgUrl) {
        this.teachImgUrl = teachImgUrl == null ? null : teachImgUrl.trim();
    }

    public Integer getTeachAge() {
        return teachAge;
    }

    public void setTeachAge(Integer teachAge) {
        this.teachAge = teachAge;
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

    public Integer getTeachState() {
        return teachState;
    }

    public void setTeachState(Integer teachState) {
        this.teachState = teachState;
    }
}