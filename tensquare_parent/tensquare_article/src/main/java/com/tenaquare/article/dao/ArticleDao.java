package com.tenaquare.article.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tenaquare.article.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @description: 文章模块持久层接口
 * @author: caipeng
 * @create: 2019-04-12 18:20
 */
@Mapper
public interface ArticleDao extends BaseMapper<Article> {

    /**
     * 文章审核 0：未审核 1：已审核
     *
     * @param id
     * @return
     */
    Boolean examine(@Param("id") Long id);
}