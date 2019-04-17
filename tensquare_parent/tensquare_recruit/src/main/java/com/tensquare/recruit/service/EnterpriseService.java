package com.tensquare.recruit.service;

import com.baomidou.mybatisplus.service.IService;
import com.tensquare.recruit.pojo.Enterprise;

import java.util.List;

/**
 * @description: 企业业务层接口
 * @author: caipeng
 * @create: 2019-04-10 17:37
 */
public interface EnterpriseService extends IService<Enterprise> {

    /**
     * 热门企业列表
     *
     * @return
     */
    List<Enterprise> hotlist();
}
