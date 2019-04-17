package com.tensquare.search.dao;


import com.tensquare.search.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: caipeng
 * @create: 2019-04-16 15:56
 */
@Component
public interface ArticleDao extends ElasticsearchRepository<Article, String> {
}
