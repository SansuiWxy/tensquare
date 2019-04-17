package com.tensquare.qa.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.tensquare.qa.pojo.Problem;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: caipeng
 * @create: 2019-04-11 15:24
 */
public interface ProblemService extends IService<Problem> {


    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Problem> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Problem> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     *
     * @param problem
     * @return
     */
    public List<Problem> findSearch(Problem problem);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Problem findById(Long id);

    /**
     * 增加
     *
     * @param problem
     */
    public void add(Problem problem);

    /**
     * 修改
     *
     * @param problem
     */
    public void update(Problem problem);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);


    /**
     * 多条件分页查询
     *
     * @param ew
     * @return
     */
    List<Problem> pageQuery(EntityWrapper<Problem> ew);

    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelId
     * @param page
     * @param size
     * @return
     */
    PageResult<Problem> findNewReplyList(Long labelId, Integer page, Integer size);
}
