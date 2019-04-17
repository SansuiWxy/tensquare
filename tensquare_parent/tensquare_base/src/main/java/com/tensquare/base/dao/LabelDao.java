package com.tensquare.base.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.base.pojo.Label;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 标签数据访问接口
 * @author: caipeng
 * @create: 2019-04-01 18:27
 */
@Mapper
public interface LabelDao extends BaseMapper<Label> {

    /**
     * 添加标签
     *
     * @param label
     * @return
     */
    @Override
    Integer insert(Label label);

    /**
     * 根据条件查询
     *
     * @param label
     * @return
     */
//    @Select("<script> select *\n" +
//            "        from tb_label\n" +
//            "        where\n" +
//            "        labelname like \'%\'#{labelname}\'%\'</script>")
//    List<Label> findSearch(Label label);
}
