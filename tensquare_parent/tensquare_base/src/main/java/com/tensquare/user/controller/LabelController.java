package com.tensquare.user.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 标签控制层
 * @author: caipeng
 * @create: 2019-04-02 09:46
 */
@RestController
@RequestMapping("/label")
@Api(value = "标签Controller", description = "Label服务接口")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 添加标签
     *
     * @param label
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加标签", notes = "新增标签", produces = "application/json")
    public Result add(@RequestBody @Valid Label label) {
        Boolean add = labelService.add(label);
        if (add) {
            return Result.success();
        }
        return Result.failure();
    }

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/selectList")
    @ApiOperation(value = "查询全部标签", notes = "查询全部标签")
    public Result findAll() {

        List<Label> labelList = labelService.findAll();
        if ((null != labelList) && labelList.size() > 0) {
            return new Result(true, StatusCode.OK, "查询成功！", labelList);
        }
        return new Result(false, StatusCode.ERROR, "查询失败！");
    }

    @GetMapping("/selectById/{id}")
    @ApiOperation(value = "查询标签信息", notes = "根据id查询标签信息", produces = "application/json")
    public Result selectById(@PathVariable("id") Integer id) {
        Label label = labelService.selectById(id);
        if (null != label) {
            return new Result(true, StatusCode.OK, "查询成功！", label);
        }
        return new Result(false, StatusCode.ERROR, "查询失败！");
    }


    /**
     * 删除标签
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteByid/{id}")
    @ApiOperation(value = "删除标签", notes = "根据标签id删除标签", produces = "application/json")
    public Result deleteById(@PathVariable("id") Integer id) {
        Boolean del = labelService.deleteById(id);
        if (del) {
            return new Result(true, StatusCode.OK, "删除成功！");
        }
        return new Result(false, StatusCode.ERROR, "删除失败！");
    }


    /**
     * 更新标签信息
     *
     * @param label
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "更新标签", notes = "更新全部标签", produces = "application/json")
    public Result updateById(@RequestBody @Valid Label label) {
        boolean b = labelService.updateById(label);
        if (b) {
            return new Result(true, StatusCode.OK, "修改成功！");
        }
        return new Result(false, StatusCode.ERROR, "修改失败！");
    }


    /**
     * 根据条件查询
     *
     * @param label
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "根据条件查询", notes = "根据条件查询", produces = "application/json")
    public Result findSearch(@RequestBody @Valid Label label) {
        List<Label> search = labelService.findSearch(label);
        if (null != search && !search.isEmpty()) {
            return new Result(true, StatusCode.OK, "查询成功！", search);
        } else {
            return new Result(false, StatusCode.ERROR, "查询失败！");
        }
    }


    /**
     * 带条件的分页查询
     *
     * @param label
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    @ApiOperation(value = "分页查询", notes = "带条件的分页查询", produces = "application/json")
    public Result pageQuery(@RequestBody @Valid Label label, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        EntityWrapper<Label> ew = new EntityWrapper<>();
        //默认值为第一页
        if (page <= 0) {
            page = 1;
        }
        //默认每页显示两条数据
        if (null == size) {
            size = 2;
        }

        // 1.判断label是否为空，不为空添加查询条件,为空查询全部
        if (null != label) {
            if (null != label.getLabelname() && "" != label.getLabelname()) {
                ew.like("labelname", label.getLabelname());
            }
            if (null != label.getRecommend() && "" != label.getRecommend()) {
                ew.like("recommend", label.getRecommend());
            }
            if (null != label.getState() && "" != label.getState()) {
                ew.like("state", label.getState());
            }
        }
        // 2.查询
        // 2.1设置分页信息，包括当前页和每页显示数量
        PageHelper.startPage(page, size);
        // 2.2执行查询
        List<Label> labelList = labelService.pageQuery(ew);
        if (null == labelList || labelList.isEmpty()) {
            return new Result(false, StatusCode.ERROR, "查询失败！没有记录！");
        }
        // 2.3获得分页查询后的数据
        PageInfo<Label> pageInfo = new PageInfo<>(labelList);
        // 2.4封装需要返回的分页实体
        PageResult<Label> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

        return new Result(true, StatusCode.OK, "查询成功！", pageResult);
    }

}
