package com.tenaquare.article.service;

import com.baomidou.mybatisplus.service.IService;
import com.tenaquare.article.pojo.Article;

/**
 * @description: 文章模块业务层接口
 * @author: caipeng
 * @create: 2019-04-12 18:20
 */
public interface ArticleService extends IService<Article> {
    /**
     * 文章审核 0：未审核 1：已审核
     *
     * @param id
     * @return
     */
    Boolean examine(Long id);
}
