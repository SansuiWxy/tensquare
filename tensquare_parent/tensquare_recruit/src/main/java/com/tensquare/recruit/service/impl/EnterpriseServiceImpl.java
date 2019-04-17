package com.tensquare.recruit.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 企业业务层接口实现类
 * @author: caipeng
 * @create: 2019-04-10 17:38
 */
@Service
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseDao, Enterprise> implements EnterpriseService {

    /**
     * 热门企业列表
     *
     * @return
     */
    @Override
    public List<Enterprise> hotlist() {
        List<Enterprise> hotlist = baseMapper.selectByIshot("1");
        if (hotlist != null) {
            return hotlist;
        }
        return null;
    }
}
