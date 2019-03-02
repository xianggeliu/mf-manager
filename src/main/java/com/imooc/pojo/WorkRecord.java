package com.imooc.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "work_record")
public class WorkRecord {
    @Id
    private String id;

    /**
     * 作者ID
     */
    @Column(name = "author_id")
    private String authorId;

    /**
     * 作者姓名
     */
    @Column(name = "author_name")
    private String authorName;

    /**
     * 头像图片地址
     */
    @Column(name = "head_img_url")
    private String headImgUrl;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 作品类型 1 视频 ， 2：图片 ， 3 ： 文章
     */
    @Column(name = "work_type")
    private Byte workType;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 作品编号
     */
    @Column(name = "work_number")
    private String workNumber;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 备用
     */
    @Column(name = "content_id")
    private Integer contentId;

    /**
     * 发布时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 点赞数
     */
    @Column(name = "praise_num")
    private Integer praiseNum;

    /**
     * 审核状态：0=待审核；1=审核中；2=通过；3=不通过；
     */
    @Column(name = "approve_status")
    private Boolean approveStatus;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取作者ID
     *
     * @return author_id - 作者ID
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * 设置作者ID
     *
     * @param authorId 作者ID
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * 获取作者姓名
     *
     * @return author_name - 作者姓名
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * 设置作者姓名
     *
     * @param authorName 作者姓名
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * 获取头像图片地址
     *
     * @return head_img_url - 头像图片地址
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 设置头像图片地址
     *
     * @param headImgUrl 头像图片地址
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取作品类型 1 视频 ， 2：图片 ， 3 ： 文章
     *
     * @return work_type - 作品类型 1 视频 ， 2：图片 ， 3 ： 文章
     */
    public Byte getWorkType() {
        return workType;
    }

    /**
     * 设置作品类型 1 视频 ， 2：图片 ， 3 ： 文章
     *
     * @param workType 作品类型 1 视频 ， 2：图片 ， 3 ： 文章
     */
    public void setWorkType(Byte workType) {
        this.workType = workType;
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取作品编号
     *
     * @return work_number - 作品编号
     */
    public String getWorkNumber() {
        return workNumber;
    }

    /**
     * 设置作品编号
     *
     * @param workNumber 作品编号
     */
    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    /**
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取备用
     *
     * @return content_id - 备用
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * 设置备用
     *
     * @param contentId 备用
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * 获取发布时间
     *
     * @return create_time - 发布时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发布时间
     *
     * @param createTime 发布时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取点赞数
     *
     * @return praise_num - 点赞数
     */
    public Integer getPraiseNum() {
        return praiseNum;
    }

    /**
     * 设置点赞数
     *
     * @param praiseNum 点赞数
     */
    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    /**
     * 获取审核状态：0=待审核；1=审核中；2=通过；3=不通过；
     *
     * @return approve_status - 审核状态：0=待审核；1=审核中；2=通过；3=不通过；
     */
    public Boolean getApproveStatus() {
        return approveStatus;
    }

    /**
     * 设置审核状态：0=待审核；1=审核中；2=通过；3=不通过；
     *
     * @param approveStatus 审核状态：0=待审核；1=审核中；2=通过；3=不通过；
     */
    public void setApproveStatus(Boolean approveStatus) {
        this.approveStatus = approveStatus;
    }
}