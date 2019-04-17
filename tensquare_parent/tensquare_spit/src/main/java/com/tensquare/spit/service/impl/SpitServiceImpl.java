package com.tensquare.spit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * @description: 吐槽模块业务层实现类
 * @author: caipeng
 * @create: 2019-04-15 10:06
 */
@Service
public class SpitServiceImpl implements SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 查询全部记录
     *
     * @return
     */
    @Override
    public List<Spit> findAll() {
        List<Spit> all = spitDao.findAll();
        if (all.size() > 0 && null != all) {
            return all;
        }
        return null;
    }


    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Spit findOne(String id) {
        Spit spit = spitDao.findById(id).get();
        if (null != spit) {
            return spit;
        }
        return null;
    }

    /**
     * 添加
     *
     * @param spit
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(Spit spit) {
        spit.set_id(IdWorker.getId() + "");
        //发布日期
        spit.setPublishtime(new Date());
        //浏览量
        spit.setVisits(0);
        //分享数
        spit.setShare(0);
        //点赞数
        spit.setThumbup(0);
        //回复数
        spit.setComment(0);
        //状态
        spit.setState("1");

        //如果当前添加的吐槽有父节点，那么父节点的吐槽回复数要加1
        if (spit.getParentid() != null && !"".equals(spit.getParentid())) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateMulti(query, update, "spit");
        }

        spitDao.save(spit);
    }


    /**
     * 修改
     *
     * @param spit
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }


    /**
     * 根据上级id查询吐槽分页数据
     *
     * @param id
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Spit> findByParentId(String id, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Spit> spits = spitDao.findByParentid(id, pageable);
        if (spits != null) {
            return spits;
        }
        return null;
    }

    /**
     * 点赞
     *
     * @param id
     */
    @Override
    public void updateThumbup(String id) {
        //创建query对象
        Query query = new Query();
        //添加查询条件
        query.addCriteria(Criteria.where("_id").is(id));

        Update update = new Update();

        update.inc("thumbup", 1);
        mongoTemplate.updateMulti(query, update, "spit");
    }

}
