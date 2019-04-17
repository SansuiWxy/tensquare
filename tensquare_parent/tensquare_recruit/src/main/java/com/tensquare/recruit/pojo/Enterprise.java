package com.tensquare.recruit.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @description: 企业实体类
 * @author: caipeng
 * @create: 2019-04-10 16:28
 */
@ApiModel(value = "Enterprise", description = "企业实体类")
@TableName(value = "tb_enterprise")
public class Enterprise implements Serializable {

    /**
     * 主键
     */
    @ApiModelProperty(value = "企业id")
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    @TableField
    private String name;

    /**
     * 企业简介
     */
    @ApiModelProperty(value = "企业简介")
    @TableField
    private String summary;

    /**
     * 企业地址
     */
    @ApiModelProperty(value = "企业地址")
    @TableField
    private String address;

    /**
     * 企业地址
     */
    @ApiModelProperty(value = "企业地址")
    @TableField
    private String labels;

    /**
     * 坐标
     */
    @ApiModelProperty(value = "坐标")
    @TableField
    private String coordinate;

    /**
     * 是否热门
     */
    @ApiModelProperty(value = "是否热门")
    @TableField
    private String ishot;

    /**
     * LOGO
     */
    @ApiModelProperty(value = "企业LOGO")
    @TableField
    private String logo;

    /**
     * 职位数
     */
    @ApiModelProperty(value = "职位数")
    @TableField
    private String jobcount;

    /**
     * url
     */
    @ApiModelProperty(value = "url")
    @TableField
    private String url;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getIshot() {
        return ishot;
    }

    public void setIshot(String ishot) {
        this.ishot = ishot;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getJobcount() {
        return jobcount;
    }

    public void setJobcount(String jobcount) {
        this.jobcount = jobcount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", address='" + address + '\'' +
                ", labels='" + labels + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", ishot='" + ishot + '\'' +
                ", logo='" + logo + '\'' +
                ", jobcount='" + jobcount + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
