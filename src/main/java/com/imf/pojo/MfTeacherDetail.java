package com.imf.pojo;

public class MfTeacherDetail {
    private String teachId;

    private String teachIdnum;

    private String teachEdu;

    private String teachEduSchool;

    private String teachEduTime;

    private String teachAddress;

    private Integer teachPhone;

    private Boolean teachMaritalState;

    public String getTeachId() {
        return teachId;
    }

    public void setTeachId(String teachId) {
        this.teachId = teachId == null ? null : teachId.trim();
    }

    public String getTeachIdnum() {
        return teachIdnum;
    }

    public void setTeachIdnum(String teachIdnum) {
        this.teachIdnum = teachIdnum == null ? null : teachIdnum.trim();
    }

    public String getTeachEdu() {
        return teachEdu;
    }

    public void setTeachEdu(String teachEdu) {
        this.teachEdu = teachEdu == null ? null : teachEdu.trim();
    }

    public String getTeachEduSchool() {
        return teachEduSchool;
    }

    public void setTeachEduSchool(String teachEduSchool) {
        this.teachEduSchool = teachEduSchool == null ? null : teachEduSchool.trim();
    }

    public String getTeachEduTime() {
        return teachEduTime;
    }

    public void setTeachEduTime(String teachEduTime) {
        this.teachEduTime = teachEduTime == null ? null : teachEduTime.trim();
    }

    public String getTeachAddress() {
        return teachAddress;
    }

    public void setTeachAddress(String teachAddress) {
        this.teachAddress = teachAddress == null ? null : teachAddress.trim();
    }

    public Integer getTeachPhone() {
        return teachPhone;
    }

    public void setTeachPhone(Integer teachPhone) {
        this.teachPhone = teachPhone;
    }

    public Boolean getTeachMaritalState() {
        return teachMaritalState;
    }

    public void setTeachMaritalState(Boolean teachMaritalState) {
        this.teachMaritalState = teachMaritalState;
    }
}