package com.tenaquare.article.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import src.main.java.com.tenaquare.article.dao.TbChannel;
import src.main.java.com.tenaquare.article.dao.TbChannelExample;

public interface ChannelDao {
    long countByExample(TbChannelExample example);

    int deleteByExample(TbChannelExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbChannel record);

    int insertSelective(TbChannel record);

    List<TbChannel> selectByExample(TbChannelExample example);

    TbChannel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbChannel record, @Param("example") TbChannelExample example);

    int updateByExample(@Param("record") TbChannel record, @Param("example") TbChannelExample example);

    int updateByPrimaryKeySelective(TbChannel record);

    int updateByPrimaryKey(TbChannel record);
}