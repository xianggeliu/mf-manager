package com.imf.pojo;

import javax.persistence.*;

@Table(name = "mf_teacher_detail")
public class MfTeacherDetail {
    /**
     * 教师编号
     */
    @Id
    @Column(name = "teach_id")
    private String teachId;

    /**
     * 教师身份证号码
     */
    @Column(name = "teach_idnum")
    private String teachIdnum;

    /**
     * 学历
     */
    @Column(name = "teach_edu")
    private String teachEdu;

    /**
     * 毕业学校
     */
    @Column(name = "teach_edu_school")
    private String teachEduSchool;

    /**
     * 毕业时间
     */
    @Column(name = "teach_edu_time")
    private String teachEduTime;

    /**
     * 家庭住址
     */
    @Column(name = "teach_address")
    private String teachAddress;

    /**
     * 联系电话
     */
    @Column(name = "teach_phone")
    private Integer teachPhone;

    /**
     * 婚姻状态 1 是未婚  2 是已婚  0 是离婚
     */
    @Column(name = "teach_marital_state")
    private Boolean teachMaritalState;

    /**
     * 获取教师编号
     *
     * @return teach_id - 教师编号
     */
    public String getTeachId() {
        return teachId;
    }

    /**
     * 设置教师编号
     *
     * @param teachId 教师编号
     */
    public void setTeachId(String teachId) {
        this.teachId = teachId;
    }

    /**
     * 获取教师身份证号码
     *
     * @return teach_idnum - 教师身份证号码
     */
    public String getTeachIdnum() {
        return teachIdnum;
    }

    /**
     * 设置教师身份证号码
     *
     * @param teachIdnum 教师身份证号码
     */
    public void setTeachIdnum(String teachIdnum) {
        this.teachIdnum = teachIdnum;
    }

    /**
     * 获取学历
     *
     * @return teach_edu - 学历
     */
    public String getTeachEdu() {
        return teachEdu;
    }

    /**
     * 设置学历
     *
     * @param teachEdu 学历
     */
    public void setTeachEdu(String teachEdu) {
        this.teachEdu = teachEdu;
    }

    /**
     * 获取毕业学校
     *
     * @return teach_edu_school - 毕业学校
     */
    public String getTeachEduSchool() {
        return teachEduSchool;
    }

    /**
     * 设置毕业学校
     *
     * @param teachEduSchool 毕业学校
     */
    public void setTeachEduSchool(String teachEduSchool) {
        this.teachEduSchool = teachEduSchool;
    }

    /**
     * 获取毕业时间
     *
     * @return teach_edu_time - 毕业时间
     */
    public String getTeachEduTime() {
        return teachEduTime;
    }

    /**
     * 设置毕业时间
     *
     * @param teachEduTime 毕业时间
     */
    public void setTeachEduTime(String teachEduTime) {
        this.teachEduTime = teachEduTime;
    }

    /**
     * 获取家庭住址
     *
     * @return teach_address - 家庭住址
     */
    public String getTeachAddress() {
        return teachAddress;
    }

    /**
     * 设置家庭住址
     *
     * @param teachAddress 家庭住址
     */
    public void setTeachAddress(String teachAddress) {
        this.teachAddress = teachAddress;
    }

    /**
     * 获取联系电话
     *
     * @return teach_phone - 联系电话
     */
    public Integer getTeachPhone() {
        return teachPhone;
    }

    /**
     * 设置联系电话
     *
     * @param teachPhone 联系电话
     */
    public void setTeachPhone(Integer teachPhone) {
        this.teachPhone = teachPhone;
    }

    /**
     * 获取婚姻状态 1 是未婚  2 是已婚  0 是离婚
     *
     * @return teach_marital_state - 婚姻状态 1 是未婚  2 是已婚  0 是离婚
     */
    public Boolean getTeachMaritalState() {
        return teachMaritalState;
    }

    /**
     * 设置婚姻状态 1 是未婚  2 是已婚  0 是离婚
     *
     * @param teachMaritalState 婚姻状态 1 是未婚  2 是已婚  0 是离婚
     */
    public void setTeachMaritalState(Boolean teachMaritalState) {
        this.teachMaritalState = teachMaritalState;
    }
}