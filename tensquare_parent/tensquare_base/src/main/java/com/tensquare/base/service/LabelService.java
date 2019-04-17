package com.tensquare.base.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.tensquare.base.pojo.Label;
import entity.PageResult;

import java.util.List;

/**
 * @description: 标签业务接口
 * @author: caipeng
 * @create: 2019-04-02 09:39
 */
public interface LabelService extends IService<Label> {

    /**
     * 增加标签
     *
     * @param label
     * @return
     */
    Boolean add(Label label);

    /**
     * 根据标签id删除
     *
     * @param id
     * @return
     */
    Boolean deleteById(Integer id);


    /**
     * 根据标签id修改
     *
     * @return
     */
    boolean updateById(Label label);

    /**
     * 根据标签id查询
     *
     * @param id
     * @return
     */
    Label selectById(Integer id);

    /**
     * 查询全部
     *
     * @return
     */
    List<Label> findAll();


    /**
     * 根据条件查询
     *
     * @param label
     * @return
     */
    List<Label> findSearch(Label label);


    /**
     * 带条件的分页查询
     *
     * @param ew
     * @return
     */
    List<Label> pageQuery(EntityWrapper<Label> ew);
}
