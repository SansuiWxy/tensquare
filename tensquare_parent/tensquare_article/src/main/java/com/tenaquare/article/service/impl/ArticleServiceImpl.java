package com.tenaquare.article.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tenaquare.article.dao.ArticleDao;
import com.tenaquare.article.pojo.Article;
import com.tenaquare.article.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @description: 文章模块业务层接口实现类
 * @author: caipeng
 * @create: 2019-04-12 18:20
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    /**
     * 文章审核 0：未审核 1：已审核
     *
     * @param id
     * @return
     */
    @Override
    public Boolean examine(Long id) {
        Boolean flag = baseMapper.examine(id);
        if (flag) {
            return true;
        }
        return false;
    }
}
