package com.tensquare.qa.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.tensquare.qa.pojo.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ProblemDao extends BaseMapper<Problem> {

    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelId
     * @return
     */
    List<Problem> findNewReplyList(@Param("labelid") Long labelId);
}
