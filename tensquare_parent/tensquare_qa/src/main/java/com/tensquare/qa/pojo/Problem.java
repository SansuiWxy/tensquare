package com.tensquare.qa.pojo;


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
 * 问题实体类
 *
 * @author caipeng
 */
@TableName(value = "tb_problem")
@ApiModel(value = "问题实体类", description = "问题实体类")
public class Problem implements Serializable {


    @TableId(type = IdType.ID_WORKER)
    @ApiModelProperty(value = "问题id")
    private String id;


    /**
     * 标题
     */
    @TableField
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 内容
     */
    @TableField
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 创建日期
     */
    @TableField
    @ApiModelProperty(value = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    /**
     * 修改日期
     */
    @TableField
    @ApiModelProperty(value = "修改日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatetime;

    /**
     * 用户ID
     */
    @TableField
    @ApiModelProperty(value = "用户ID")
    private Long userid;

    /**
     * 昵称
     */
    @TableField
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 浏览量
     */
    @TableField
    @ApiModelProperty(value = "浏览量")
    private Long visits;

    /**
     * 点赞数
     */
    @TableField
    @ApiModelProperty(value = "点赞数")
    private Long thumbup;

    /**
     * 回复数
     */
    @TableField
    @ApiModelProperty(value = "回复数")
    private Long reply;

    /**
     * 是否解决
     */
    @TableField
    @ApiModelProperty(value = "是否解决")
    private String solve;

    /**
     * 回复人昵称
     */
    @TableField
    @ApiModelProperty(value = "回复人昵称")
    private String replyname;

    /**
     * 回复日期
     */
    @TableField
    @ApiModelProperty(value = "回复日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date replytime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public java.util.Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.util.Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(java.util.Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getVisits() {
        return visits;
    }

    public void setVisits(Long visits) {
        this.visits = visits;
    }

    public Long getThumbup() {
        return thumbup;
    }

    public void setThumbup(Long thumbup) {
        this.thumbup = thumbup;
    }

    public Long getReply() {
        return reply;
    }

    public void setReply(Long reply) {
        this.reply = reply;
    }

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyname) {
        this.replyname = replyname;
    }

    public java.util.Date getReplytime() {
        return replytime;
    }

    public void setReplytime(java.util.Date replytime) {
        this.replytime = replytime;
    }


}
