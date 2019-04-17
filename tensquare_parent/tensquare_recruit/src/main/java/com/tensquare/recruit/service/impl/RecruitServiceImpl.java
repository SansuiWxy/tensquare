package com.tensquare.recruit.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 招聘业务层接口实现类
 * @author: caipeng
 * @create: 2019-04-10 17:29
 */
@Service
public class RecruitServiceImpl extends ServiceImpl<RecruitDao, Recruit> implements RecruitService {

    /**
     * 根据是否推荐状态查询前4位，并按时间降序
     *
     * @param states
     * @return
     */
    @Override
    public List<Recruit> findTop4ByStatesOrderByCreatetimeDesc(String states) {
        List<Recruit> recruitList = baseMapper.findTop4ByStatesOrderByCreatetimeDesc(states);
        if (null != recruitList && !recruitList.isEmpty()) {
            return recruitList;
        }
        return null;
    }

    /**
     * 查询状态不为0并以创建日期降序排序，查询前12条记录  state: 0：关闭 1:开启 2：推荐
     *
     * @param state
     * @return
     */
    @Override
    public List<Recruit> findNewRecruit(String state) {
        List<Recruit> newRecruitList = baseMapper.findTop12ByStatesNot0AndOrderByCreatetimeDesc(state);
        if (null != newRecruitList && !newRecruitList.isEmpty()) {
            return newRecruitList;
        }
        return null;
    }

    /**
     * 新增招聘
     *
     * @param recruit
     * @return
     */
    @Override
    public boolean saveRecruit(Recruit recruit) {
        Integer insert = baseMapper.insert(recruit);
        return insert > 0 ? true : false;
    }

    /**
     * 全部招聘列表
     *
     * @return
     */
    @Override
    public List<Recruit> allRecruit() {
        List<Recruit> recruitList = baseMapper.selectAllList();
        if (recruitList.size() > 0 && null != recruitList) {
            return recruitList;
        }
        return null;
    }
}
