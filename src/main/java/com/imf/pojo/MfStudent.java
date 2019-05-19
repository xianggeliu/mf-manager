package com.imf.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mf_student")
public class MfStudent {
    /**
     * id自增长
     */
    @Id
    private Integer id;

    /**
     * 学生id
     */
    @Column(name = "stu_uuid")
    private String stuUuid;

    /**
     * 学生姓名不能为空
     */
    @Column(name = "stu_name")
    private String stuName;

    /**
     * 学生年龄
     */
    @Column(name = "stu_age")
    private Byte stuAge;

    /**
     * 学生性别1是男生，
     */
    @Column(name = "stu_gender")
    private Byte stuGender;

    /**
     * 上传照片路径
     */
    @Column(name = "stu_img_url")
    private String stuImgUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "edit_time")
    private Date editTime;

    /**
     * 学生状态 1是正常  2是毕业  0 是不正常
     */
    @Column(name = "stu_state")
    private Boolean stuState;

    /**
     * 获取id自增长
     *
     * @return id - id自增长
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id自增长
     *
     * @param id id自增长
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * 获取学生姓名不能为空
     *
     * @return stu_name - 学生姓名不能为空
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * 设置学生姓名不能为空
     *
     * @param stuName 学生姓名不能为空
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * 获取学生年龄
     *
     * @return stu_age - 学生年龄
     */
    public Byte getStuAge() {
        return stuAge;
    }

    /**
     * 设置学生年龄
     *
     * @param stuAge 学生年龄
     */
    public void setStuAge(Byte stuAge) {
        this.stuAge = stuAge;
    }

    /**
     * 获取学生性别1是男生，
     *
     * @return stu_gender - 学生性别1是男生，
     */
    public Byte getStuGender() {
        return stuGender;
    }

    /**
     * 设置学生性别1是男生，
     *
     * @param stuGender 学生性别1是男生，
     */
    public void setStuGender(Byte stuGender) {
        this.stuGender = stuGender;
    }

    /**
     * 获取上传照片路径
     *
     * @return stu_img_url - 上传照片路径
     */
    public String getStuImgUrl() {
        return stuImgUrl;
    }

    /**
     * 设置上传照片路径
     *
     * @param stuImgUrl 上传照片路径
     */
    public void setStuImgUrl(String stuImgUrl) {
        this.stuImgUrl = stuImgUrl;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return edit_time - 修改时间
     */
    public Date getEditTime() {
        return editTime;
    }

    /**
     * 设置修改时间
     *
     * @param editTime 修改时间
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    /**
     * 获取学生状态 1是正常  2是毕业  0 是不正常
     *
     * @return stu_state - 学生状态 1是正常  2是毕业  0 是不正常
     */
    public Boolean getStuState() {
        return stuState;
    }

    /**
     * 设置学生状态 1是正常  2是毕业  0 是不正常
     *
     * @param stuState 学生状态 1是正常  2是毕业  0 是不正常
     */
    public void setStuState(Boolean stuState) {
        this.stuState = stuState;
    }
}