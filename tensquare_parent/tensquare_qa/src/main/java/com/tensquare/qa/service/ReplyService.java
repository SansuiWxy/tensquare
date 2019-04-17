package com.tensquare.qa.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.tensquare.qa.pojo.Reply;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: caipeng
 * @create: 2019-04-11 16:14
 */
public interface ReplyService extends IService<Reply> {

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Reply> findAll();


    /**
     * 条件查询
     *
     * @param reply
     * @return
     */
    public List<Reply> findSearch(Reply reply);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Reply findById(Long id);

    /**
     * 增加
     *
     * @param reply
     */
    public void add(Reply reply);

    /**
     * 修改
     *
     * @param reply
     */
    public void update(Reply reply);

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
    List<Reply> pageQuery(EntityWrapper<Reply> ew);
}
