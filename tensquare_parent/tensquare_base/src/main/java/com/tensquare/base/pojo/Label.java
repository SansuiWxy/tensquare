package com.tensquare.base.pojo;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @description: 标签实体类
 * @author: caipeng
 * @create: 2019-04-01 17:40
 */
@TableName(value = "tb_label")
@ApiModel(value = "Label", description = "标签实体类")
public class Label implements Serializable {

    /**
     * 主键，标签ID
     */
    @ApiModelProperty(value = "标签id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 标签名称
     */
    @ApiModelProperty(value = "标签名")
    @TableField
    private String labelname;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField
    private String state;

    /**
     * 使用数量
     */
    @ApiModelProperty(value = "使用数量")
    @TableField
    private Integer count;

    /**
     * 粉丝数
     */
    @ApiModelProperty(value = "粉丝数")
    @TableField
    private Integer fans;

    /**
     * 是否推荐
     */
    @ApiModelProperty(value = "是否推荐")
    @TableField
    private String recommend;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", labelname='" + labelname + '\'' +
                ", state='" + state + '\'' +
                ", count=" + count +
                ", fans=" + fans +
                ", recommend='" + recommend + '\'' +
                '}';
    }
}
