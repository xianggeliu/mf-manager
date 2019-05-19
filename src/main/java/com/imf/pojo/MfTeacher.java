package com.imf.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mf_teacher")
public class MfTeacher {
    /**
     * id自增长
     */
    @Id
    private Integer id;

    /**
     * 教师编号
     */
    @Column(name = "teach_id")
    private String teachId;

    /**
     * 教师姓名
     */
    @Column(name = "teach_name")
    private String teachName;

    /**
     * 教师性别
     */
    @Column(name = "teach_gender")
    private Boolean teachGender;

    /**
     * 教师照片
     */
    @Column(name = "teach_img_url")
    private String teachImgUrl;

    /**
     * 教师年龄
     */
    @Column(name = "teach_age")
    private Byte teachAge;

    /**
     * 录入时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "edit_time")
    private Date editTime;

    /**
     * 教师状态 1 正常 0 离职  2其他
     */
    @Column(name = "teach_state")
    private Boolean teachState;

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
     * 获取教师姓名
     *
     * @return teach_name - 教师姓名
     */
    public String getTeachName() {
        return teachName;
    }

    /**
     * 设置教师姓名
     *
     * @param teachName 教师姓名
     */
    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    /**
     * 获取教师性别
     *
     * @return teach_gender - 教师性别
     */
    public Boolean getTeachGender() {
        return teachGender;
    }

    /**
     * 设置教师性别
     *
     * @param teachGender 教师性别
     */
    public void setTeachGender(Boolean teachGender) {
        this.teachGender = teachGender;
    }

    /**
     * 获取教师照片
     *
     * @return teach_img_url - 教师照片
     */
    public String getTeachImgUrl() {
        return teachImgUrl;
    }

    /**
     * 设置教师照片
     *
     * @param teachImgUrl 教师照片
     */
    public void setTeachImgUrl(String teachImgUrl) {
        this.teachImgUrl = teachImgUrl;
    }

    /**
     * 获取教师年龄
     *
     * @return teach_age - 教师年龄
     */
    public Byte getTeachAge() {
        return teachAge;
    }

    /**
     * 设置教师年龄
     *
     * @param teachAge 教师年龄
     */
    public void setTeachAge(Byte teachAge) {
        this.teachAge = teachAge;
    }

    /**
     * 获取录入时间
     *
     * @return create_time - 录入时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置录入时间
     *
     * @param createTime 录入时间
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
     * 获取教师状态 1 正常 0 离职  2其他
     *
     * @return teach_state - 教师状态 1 正常 0 离职  2其他
     */
    public Boolean getTeachState() {
        return teachState;
    }

    /**
     * 设置教师状态 1 正常 0 离职  2其他
     *
     * @param teachState 教师状态 1 正常 0 离职  2其他
     */
    public void setTeachState(Boolean teachState) {
        this.teachState = teachState;
    }
}