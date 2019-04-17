package com.tensquare.recruit.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.recruit.pojo.Recruit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecruitDao extends BaseMapper<Recruit> {

    /**
     * 根据是否推荐状态查询前4位，并按时间降序
     *
     * @param states
     * @return
     */
    List<Recruit> findTop4ByStatesOrderByCreatetimeDesc(@Param("state") String states);

    /**
     * 查询状态不为0并以创建日期降序排序，查询前12条记录  state: 0：关闭 1:开启 2：推荐
     *
     * @param state
     * @return
     */
    List<Recruit> findTop12ByStatesNot0AndOrderByCreatetimeDesc(String state);

    /**
     * 查询全部招聘
     *
     * @return
     */
    List<Recruit> selectAllList();
}