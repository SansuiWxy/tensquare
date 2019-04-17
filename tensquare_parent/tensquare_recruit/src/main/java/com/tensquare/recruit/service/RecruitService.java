package com.tensquare.recruit.service;

import com.baomidou.mybatisplus.service.IService;
import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * @description: 招聘业务层接口
 * @author: caipeng
 * @create: 2019-04-10 17:28
 */
public interface RecruitService extends IService<Recruit> {

    /**
     * 根据是否推荐状态查询前4位，并按时间降序
     *
     * @param s
     * @return
     */
    List<Recruit> findTop4ByStatesOrderByCreatetimeDesc(String s);

    /**
     * 查询状态不为0并以创建日期降序排序，查询前12条记录  state: 0：关闭 1:开启 2：推荐
     *
     * @param state
     * @return
     */
    List<Recruit> findNewRecruit(String state);

    /**
     * 新增招聘
     *
     * @param recruit
     * @return
     */
    boolean saveRecruit(Recruit recruit);

    /**
     * 全部招聘列表
     *
     * @return
     */
    List<Recruit> allRecruit();
}
