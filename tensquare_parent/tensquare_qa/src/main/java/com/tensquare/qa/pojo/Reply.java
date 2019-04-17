package com.tensquare.qa.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 回答实体类
 *
 * @author Administrator
 */
@TableName(value = "tb_reply")
public class Reply implements Serializable {

    /**
     * 编号
     */
    @TableId(type = IdType.ID_WORKER)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 问题ID
     */
    @TableField
    @ApiModelProperty(value = "问题ID")
    private Long problemid;

    /**
     * 回答内容
     */
    @TableField
    @ApiModelProperty(value = "回答内容")
    private String content;

    /**
     * 创建日期
     */
    @TableField
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createtime;


    /**
     * 更新日期
     */
    @TableField
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updatetime;

    /**
     * 回答人ID
     */
    @TableField
    @ApiModelProperty(value = "回答人ID")
    private Long userid;

    /**
     * 回答人昵称
     */
    @TableField
    @ApiModelProperty(value = "回答人昵称")
    private String nickname;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProblemid() {
        return problemid;
    }

    public void setProblemid(Long problemid) {
        this.problemid = problemid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
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

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", problemid='" + problemid + '\'' +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", userid='" + userid + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
