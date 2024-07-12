package com.tenaquare.article.service;

import com.baomidou.mybatisplus.service.IService;
import com.tenaquare.article.pojo.Article;

/**
 * @description: 文章模块业务层接口 dev 修改2  测试cherry pick33 不需要提交
 * @author: caipeng
 * @create: 2019-04-12 18:20
 */
public interface ArticleService extends IService<Article> {
    /**
     * 文章审核 0：未审核 1：已审核 22
     *
     * @param id
     * @return
     */
    Boolean examine(Long id);
}
