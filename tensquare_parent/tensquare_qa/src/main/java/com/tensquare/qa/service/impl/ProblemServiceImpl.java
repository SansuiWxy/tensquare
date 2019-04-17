package com.tensquare.qa.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: caipeng
 * @create: 2019-04-11 15:37
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemDao, Problem> implements ProblemService {
    @Override
    public List<Problem> findAll() {
        EntityWrapper<Problem> ew = new EntityWrapper<>();
        List<Problem> problemList = baseMapper.selectList(ew);
        if (problemList.size() > 0 && null != problemList) {
            return problemList;
        }
        return null;
    }

    @Override
    public PageResult<Problem> findSearch(Map whereMap, int page, int size) {
        return null;
    }

    @Override
    public List<Problem> findSearch(Problem problem) {
        EntityWrapper<Problem> ew = new EntityWrapper<>();
        if (null != problem.getTitle() && "" != problem.getTitle()) {
            ew.like("title", problem.getTitle());
        }
        if (null != problem.getContent() && "" != problem.getContent()) {
            ew.like("content", problem.getContent());
        }
        if (null != problem.getSolve() && "" != problem.getSolve()) {
            ew.eq("solve", problem.getSolve());
        }
        List<Problem> problemList = baseMapper.selectList(ew);
        if (!problemList.isEmpty() && problemList != null) {
            return problemList;
        }
        return null;
    }

    @Override
    public Problem findById(Long id) {
        Problem problem = baseMapper.selectById(id);
        if (null != problem) {
            return problem;
        }
        return null;
    }

    @Override
    public void add(Problem problem) {
        baseMapper.insert(problem);
    }

    @Override
    public void update(Problem problem) {
        baseMapper.updateById(problem);
    }

    @Override
    public void deleteById(String id) {
        baseMapper.deleteById(id);

    }

    @Override
    public List<Problem> pageQuery(EntityWrapper<Problem> ew) {

        List<Problem> problemList = baseMapper.selectList(ew);
        if (null != problemList && !problemList.isEmpty()) {
            return problemList;
        }
        return null;
    }

    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelId
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<Problem> findNewReplyList(Long labelId, Integer page, Integer size) {
        if (page <= 0) {
            page = 1;
        }
        if (size == null) {
            size = 1;
        }

        //1.调用dao层方法查询数据
        List<Problem> problemList = baseMapper.findNewReplyList(labelId);
        if (problemList == null || problemList.size() <= 0) {
            return null;
        }
        //2.设置分页信息，包括当前页和每页显示数量
        PageHelper.startPage(page, size);

        //3.获得分页查询后的数据
        PageInfo<Problem> pageInfo = new PageInfo<>(problemList);

        //4.封装需要返回的分页实体
        PageResult<Problem> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
        return pageResult;
    }
}
