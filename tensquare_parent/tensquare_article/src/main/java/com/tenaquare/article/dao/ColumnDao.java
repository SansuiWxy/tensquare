package com.tenaquare.article.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import src.main.java.com.tenaquare.article.dao.TbColumn;
import src.main.java.com.tenaquare.article.dao.TbColumnExample;

public interface ColumnDao {
    long countByExample(TbColumnExample example);

    int deleteByExample(TbColumnExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbColumn record);

    int insertSelective(TbColumn record);

    List<TbColumn> selectByExample(TbColumnExample example);

    TbColumn selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbColumn record, @Param("example") TbColumnExample example);

    int updateByExample(@Param("record") TbColumn record, @Param("example") TbColumnExample example);

    int updateByPrimaryKeySelective(TbColumn record);

    int updateByPrimaryKey(TbColumn record);
}