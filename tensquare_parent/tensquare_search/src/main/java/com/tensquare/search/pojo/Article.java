package com.tensquare.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @description: 索引文章实体
 * @author: caipeng
 * @create: 2019-04-16 12:41
 */
@Document(indexName = "tensquare_article", type = "article")
public class Article implements Serializable {

    /**
     * id
     */
    @Id
    private String id;

    /**
     * 标题
     * 是否索引，就是看该域能否被搜索
     * 是否分词，就表示是搜索的时候是整体匹配还是单词匹配
     * 是否存储，就是是否在页面上显示
     */
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;


    /**
     * 文章正文
     */
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;

    /**
     * 审核状态
     */
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
