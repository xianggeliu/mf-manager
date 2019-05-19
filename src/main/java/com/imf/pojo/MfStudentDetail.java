package com.imf.pojo;

import javax.persistence.*;

@Table(name = "mf_student_detail")
public class MfStudentDetail {
    /**
     * 学生id
     */
    @Id
    @Column(name = "stu_uuid")
    private String stuUuid;

    /**
     * 监护人姓名
     */
    @Column(name = "stu_parent_name")
    private String stuParentName;

    /**
     * 家庭住址
     */
    @Column(name = "stu_address")
    private String stuAddress;

    /**
     * 联系电话
     */
    @Column(name = "stu_phone_num")
    private Integer stuPhoneNum;

    /**
     * 获取学生id
     *
     * @return stu_uuid - 学生id
     */
    public String getStuUuid() {
        return stuUuid;
    }

    /**
     * 设置学生id
     *
     * @param stuUuid 学生id
     */
    public void setStuUuid(String stuUuid) {
        this.stuUuid = stuUuid;
    }

    /**
     * 获取监护人姓名
     *
     * @return stu_parent_name - 监护人姓名
     */
    public String getStuParentName() {
        return stuParentName;
    }

    /**
     * 设置监护人姓名
     *
     * @param stuParentName 监护人姓名
     */
    public void setStuParentName(String stuParentName) {
        this.stuParentName = stuParentName;
    }

    /**
     * 获取家庭住址
     *
     * @return stu_address - 家庭住址
     */
    public String getStuAddress() {
        return stuAddress;
    }

    /**
     * 设置家庭住址
     *
     * @param stuAddress 家庭住址
     */
    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    /**
     * 获取联系电话
     *
     * @return stu_phone_num - 联系电话
     */
    public Integer getStuPhoneNum() {
        return stuPhoneNum;
    }

    /**
     * 设置联系电话
     *
     * @param stuPhoneNum 联系电话
     */
    public void setStuPhoneNum(Integer stuPhoneNum) {
        this.stuPhoneNum = stuPhoneNum;
    }
}