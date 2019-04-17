package com.tensquare.base.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: caipeng
 * @create: 2019-04-02 09:42
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelDao, Label> implements LabelService {


    /**
     * 添加标签
     *
     * @param label
     * @return
     */
    @Override
    public Boolean add(Label label) {
        Integer insert = baseMapper.insert(label);
        return insert > 0 ? true : false;
    }


    /**
     * 根据id删除标签
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(Integer id) {
        Integer integer = baseMapper.deleteById(id);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据id修改内容
     *
     * @param label
     * @return
     */
    @Override
    public boolean updateById(Label label) {
        Integer integer = baseMapper.updateById(label);
        return integer > 0 ? true : false;
    }


    /**
     * 根据id查询标签
     *
     * @param id
     * @return
     */
    @Override
    public Label selectById(Integer id) {
        Label label = baseMapper.selectById(id);
        return null != label ? label : null;
    }

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<Label> findAll() {
        EntityWrapper<Label> wrapper = new EntityWrapper<>();
        List<Label> labelList = baseMapper.selectList(wrapper);
        if (null != labelList && labelList.size() > 0) {
            return labelList;
        }
        return null;
    }


    /**
     * 根据条件查询
     *
     * @param label
     * @return
     */
    @Override
    public List<Label> findSearch(Label label) {
        EntityWrapper<Label> ew = new EntityWrapper<>();
        if (label.getLabelname() != null && label.getLabelname() != "") {
            ew.like("labelname", label.getLabelname());
        }
        if (label.getState() != null && label.getState() != "") {
            ew.like("state", label.getState());
        }
        if (label.getRecommend() != null && label.getRecommend() != "") {
            ew.like("recommend", label.getRecommend());
        }
        List<Label> labelList = baseMapper.selectList(ew);
        if (!labelList.isEmpty() && labelList != null) {
            return labelList;
        }
        return null;

    }

    /**
     * 带条件的分页查询
     *
     * @param ew
     * @return
     */
    @Override
    public List<Label> pageQuery(EntityWrapper<Label> ew) {
        List<Label> labelList = baseMapper.selectList(ew);
        if (null != labelList && !labelList.isEmpty()) {
            return labelList;
        }
        return null;
    }


}
