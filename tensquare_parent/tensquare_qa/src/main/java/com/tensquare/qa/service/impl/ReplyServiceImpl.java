package com.tensquare.qa.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tensquare.qa.dao.ReplyDao;
import com.tensquare.qa.pojo.Reply;
import com.tensquare.qa.service.ReplyService;
import entity.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 服务层
 *
 * @author Administrator
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyDao, Reply> implements ReplyService {


    /**
     * 查询全部列表
     *
     * @return
     */
    @Override
    public List<Reply> findAll() {
        EntityWrapper<Reply> ew = new EntityWrapper<>();
        List<Reply> replies = baseMapper.selectList(ew);
        if (null != replies) {
            return replies;
        }
        return null;
    }

    /**
     * 条件查询
     *
     * @param reply
     * @return
     */
    @Override
    public List<Reply> findSearch(Reply reply) {
        EntityWrapper<Reply> ew = new EntityWrapper<>();
        if (null != reply.getId()) {
            ew.eq("id", reply.getId());
        }
        if (null != reply.getProblemid()) {
            ew.eq("problemid", reply.getProblemid());
        }
        if (null != reply.getContent() && "" != reply.getContent()) {
            ew.eq("content", reply.getContent());
        }
        if (null != reply.getUserid()) {
            ew.eq("userid", reply.getUserid());
        }
        if (null != reply.getNickname() && !"".equals(reply.getNickname())) {
            ew.eq("nickname", reply.getNickname());
        }
        List<Reply> replyList = baseMapper.selectList(ew);
        if (!replyList.isEmpty() && replyList != null) {
            return replyList;
        }
        return null;
    }

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    @Override
    public Reply findById(Long id) {
        Reply reply = baseMapper.selectById(id);
        if (null != reply) {
            return reply;
        }
        return null;
    }

    /**
     * 增加
     *
     * @param reply
     */
    @Override
    public void add(Reply reply) {
        baseMapper.insert(reply);
    }

    /**
     * 修改
     *
     * @param reply
     */
    @Override
    public void update(Reply reply) {
        baseMapper.updateById(reply);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
    }

    /**
     * 多条件分页查询
     *
     * @param ew
     * @return
     */
    @Override
    public List<Reply> pageQuery(EntityWrapper<Reply> ew) {
        List<Reply> replyList = baseMapper.selectList(ew);
        if (null != replyList && !replyList.isEmpty()) {
            return replyList;
        }
        return null;
    }

}
