package com.tensquare.spit.service;

import com.tensquare.spit.pojo.Spit;
import entity.PageResult;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @description: 吐槽模块业务层接口
 * @author: caipeng
 * @create: 2019-04-15 09:57
 */
public interface SpitService {

    /**
     * 查询全部记录
     *
     * @return
     */
    List<Spit> findAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Spit findOne(String id);

    /**
     * 添加
     *
     * @param spit
     */
    void add(Spit spit);

    /**
     * 修改
     *
     * @param spit
     */
    void update(Spit spit);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteById(String id);


    /**
     * 根据上级id查询吐槽分页数据
     *
     * @param id
     * @param page
     * @param size
     * @return
     */
    Page<Spit> findByParentId(String id, int page, int size);

    /**
     * 点赞
     *
     * @param id
     */
    void updateThumbup(String id);
}
