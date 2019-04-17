package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: caipeng
 * @create: 2019-04-16 17:16
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public void save(Article article) {
        articleDao.save(article);
    }

}
