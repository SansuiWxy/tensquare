package com.tensquare.recruit.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 招聘职位表实体
 * @author: caipeng
 * @create: 2019-04-10 16:57
 */
@TableName(value = "tb_recruit")
@ApiModel(value = "Recruit", description = "招聘职位表实体")
public class Recruit implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty(value = "招聘信息id")
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 职位名称
     */
    @TableField
    @ApiModelProperty(value = "职位名称")
    private String jobname;

    /**
     * 薪资范围
     */
    @TableField
    @ApiModelProperty(value = "薪资范围")
    private String salary;

    /**
     * 经验要求
     */
    @TableField
    @ApiModelProperty(value = "经验要求")
    private String condition;

    /**
     * 学历要求
     */
    @TableField
    @ApiModelProperty(value = "学历要求")
    private String education;

    /**
     * 任职方式
     */
    @TableField
    @ApiModelProperty(value = "任职方式")
    private String type;

    /**
     * 办公地址
     */
    @TableField
    @ApiModelProperty(value = "办公地址")
    private String address;

    /**
     * 企业ID
     */
    @TableField
    @ApiModelProperty(value = "企业ID")
    private String eid;

    /**
     * 创建日期
     */
    @TableField
    @ApiModelProperty(value = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    /**
     * 状态
     */
    @TableField
    @ApiModelProperty(value = "状态")
    private String state;

    /**
     * 网址
     */
    @TableField
    @ApiModelProperty(value = "网址")
    private String url;

    /**
     * 标签
     */
    @TableField
    @ApiModelProperty(value = "标签")
    private String label;

    /**
     * 职位描述
     */
    @TableField
    @ApiModelProperty(value = "职位描述")
    private String content1;

    /**
     * 职位要求
     */
    @TableField
    @ApiModelProperty(value = "职位要求")
    private String content2;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", jobname='" + jobname + '\'' +
                ", salary='" + salary + '\'' +
                ", condition='" + condition + '\'' +
                ", education='" + education + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", eid='" + eid + '\'' +
                ", createtime=" + createtime +
                ", state='" + state + '\'' +
                ", url='" + url + '\'' +
                ", label='" + label + '\'' +
                ", content1='" + content1 + '\'' +
                ", content2='" + content2 + '\'' +
                '}';
    }
}