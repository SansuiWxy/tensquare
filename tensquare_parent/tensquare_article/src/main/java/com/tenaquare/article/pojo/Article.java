package com.tenaquare.article.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 文章实体类
 * @author: caipeng
 * @create: 2019-04-12 18:20
 */
@TableName(value = "tb_article")
@ApiModel(value = "文章实体类", description = "文章实体类")
public class Article implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER)
    @ApiModelProperty(value = "文章id")
    private String id;

    /**
     * 专栏id
     */
    @TableField
    @ApiModelProperty(value = "专栏id")
    private String columnid;

    /**
     * 用户id
     */
    @TableField
    @ApiModelProperty(value = "用户id")
    private String userid;

    /**
     * 文章标题
     */
    @TableField
    @ApiModelProperty(value = "文章标题")
    private String title;

    /**
     * 文章封面
     */
    @TableField
    @ApiModelProperty(value = "文章封面")
    private String image;

    /**
     * 发表日期
     */
    @TableField
    @ApiModelProperty(value = "发表日期")
    private Date createtime;

    /**
     * 修改日期
     */
    @TableField
    @ApiModelProperty(value = "修改日期")
    private Date updatetime;

    /**
     * 是否公开
     */
    @TableField
    @ApiModelProperty(value = "是否公开")
    private String ispublic;

    /**
     * 是否置顶
     */
    @TableField
    @ApiModelProperty(value = "是否置顶 ")
    private String istop;

    /**
     * 浏览量
     */
    @TableField
    @ApiModelProperty(value = "浏览量")
    private Integer visits;

    /**
     * 点赞数
     */
    @TableField
    @ApiModelProperty(value = "点赞数")
    private Integer thumbup;

    /**
     * 评论数
     */
    @TableField
    @ApiModelProperty(value = "评论数")
    private Integer comment;

    /**
     * 审核状态
     */
    @TableField
    @ApiModelProperty(value = "审核状态")
    private String state;

    /**
     * 所属频道
     */
    @TableField
    @ApiModelProperty(value = "所属频道")
    private String channelid;

    /**
     * URL地址
     */
    @TableField
    @ApiModelProperty(value = "URL地址")
    private String url;

    /**
     * 文章类型
     */
    @TableField
    @ApiModelProperty(value = "文章类型")
    private String type;

    /**
     * 文章内容
     */
    @TableField
    @ApiModelProperty(value = "文章内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumnid() {
        return columnid;
    }

    public void setColumnid(String columnid) {
        this.columnid = columnid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic == null ? null : ispublic.trim();
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop == null ? null : istop.trim();
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
        this.state = state == null ? null : state.trim();
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}