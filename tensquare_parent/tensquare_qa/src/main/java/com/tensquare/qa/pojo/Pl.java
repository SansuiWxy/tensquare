package com.tensquare.qa.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: PL表实体
 * @author: caipeng
 * @create: 2019-04-11 16:55
 */
@ApiModel(value = "PL表实体", description = "PL表实体")
@TableName(value = "tb_pl")
public class Pl {


    @TableId
    @ApiModelProperty(value = "问题id")
    private String problemid;

    @TableId
    @ApiModelProperty(value = "标签id")
    private String lableid;

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLableid() {
        return lableid;
    }

    public void setLableid(String lableid) {
        this.lableid = lableid;
    }


}
