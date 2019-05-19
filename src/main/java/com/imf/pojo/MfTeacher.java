package com.imf.pojo;

import java.util.Date;

public class MfTeacher {
    private Integer id;

    private String teachId;

    private String teachName;

    private Boolean teachGender;

    private String teachImgUrl;

    private Byte teachAge;

    private Date createTime;

    private Date editTime;

    private Boolean teachState;

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

    public Boolean getTeachGender() {
        return teachGender;
    }

    public void setTeachGender(Boolean teachGender) {
        this.teachGender = teachGender;
    }

    public String getTeachImgUrl() {
        return teachImgUrl;
    }

    public void setTeachImgUrl(String teachImgUrl) {
        this.teachImgUrl = teachImgUrl == null ? null : teachImgUrl.trim();
    }

    public Byte getTeachAge() {
        return teachAge;
    }

    public void setTeachAge(Byte teachAge) {
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

    public Boolean getTeachState() {
        return teachState;
    }

    public void setTeachState(Boolean teachState) {
        this.teachState = teachState;
    }
}