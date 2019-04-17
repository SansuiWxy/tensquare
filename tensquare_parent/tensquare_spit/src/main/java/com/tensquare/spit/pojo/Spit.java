package com.tensquare.spit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 吐槽实体类
 * @author: caipeng
 * @create: 2019-04-15 09:35
 */
@ApiModel(value = "Spit", description = "吐槽实体类")
public class Spit implements Serializable {

    /**
     * id
     */
    @Id
    @ApiModelProperty(value = "id")
    private String _id;

    /**
     * 吐槽内容
     */
    @ApiModelProperty(value = "吐槽内容")
    private String content;

    /**
     * 发布日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "发布日期")
    private Date publishtime;

    /**
     * 发布人ID
     */
    @ApiModelProperty(value = "发布人ID")
    private String userid;

    /**
     * 发布人昵称
     */
    @ApiModelProperty(value = "发布人昵称")
    private String nickname;

    /**
     * 浏览量
     */
    @ApiModelProperty(value = "浏览量")
    private Integer visits;

    /**
     * 点赞数
     */
    @ApiModelProperty(value = "点赞数")
    private Integer thumbup;

    /**
     * 分享数
     */
    @ApiModelProperty(value = "分享数")
    private Integer share;

    /**
     * 回复数
     */
    @ApiModelProperty(value = "回复数")
    private Integer comment;

    /**
     * 是否可见
     */
    @ApiModelProperty(value = "是否可见")
    private String state;

    /**
     * 上级id
     */
    @ApiModelProperty(value = "上级id")
    private String parentid;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getThumbup() {
        return thumbup;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Spit{" +
                "_id='" + _id + '\'' +
                ", content='" + content + '\'' +
                ", publishtime=" + publishtime +
                ", userid='" + userid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", visits=" + visits +
                ", thumbup=" + thumbup +
                ", share=" + share +
                ", comment=" + comment +
                ", state='" + state + '\'' +
                ", parentid='" + parentid + '\'' +
                '}';
    }
}
