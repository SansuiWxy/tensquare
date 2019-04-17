package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import entity.PageResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


/**
 * @description: 吐槽模块持久层接口
 * @author: caipeng
 * @create: 2019-04-15 09:55
 */
@Component
public interface SpitDao extends MongoRepository<Spit, String> {

    /**
     * 根据上级ID查询
     *
     * @param id
     * @param pageable
     * @return
     */
    Page<Spit> findByParentid(String id, Pageable pageable);
}
