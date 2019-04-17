package com.tensquare.recruit.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.recruit.pojo.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 企业持久层接口
 * @author: caipeng
 * @create: 2019-04-10 17:35
 */
public interface EnterpriseDao extends BaseMapper<Enterprise> {

    /**
     * 热门企业列表
     *
     * @param ishot
     * @return
     */
    List<Enterprise> selectByIshot(@Param("ishot") String ishot);
}
