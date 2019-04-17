package com.tensquare.qa.controller;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/newlist/{labelid}/{page}/{size}")
    @ApiOperation(value = "最新问题列表", notes = "根据标签ID查询最新问题列表", produces = "application/json")
    public Result findNewReplyList(@PathVariable(value = "labelid") Long labelId, @PathVariable Integer page, @PathVariable Integer size) {
        PageResult<Problem> pageResult = problemService.findNewReplyList(labelId, page, size);
        if (null != pageResult) {
            return new Result(true, StatusCode.OK, "查询成功！", pageResult);
        }
        return new Result(true, StatusCode.ERROR, "查询失败！");

    }

    /**
     * 查询全部问题
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "查询全部问题", notes = "查询全部问题", produces = "application/json")
    public Result findAll() {
        List<Problem> problemList = problemService.findAll();
        if (problemList.size() > 0 && null != problemList) {
            return new Result(true, StatusCode.OK, "查询成功！", problemList);
        }
        return new Result(false, StatusCode.ERROR, "查询失败！");
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询", notes = "根据ID查询", produces = "application/json")
    public Result findById(@PathVariable Long id) {
        //1.先从缓存中查询
        Problem problem = (Problem) redisTemplate.opsForValue().get("problem_" + id);
        if (problem == null) {
            //2.如果缓存中没有，再去数据库中查
            problem = problemService.findById(id);
            if (null != problem) {
                //3.将查到的数据存放到缓存中
                redisTemplate.opsForValue().set("problem_" + id, problem);
                return new Result(true, StatusCode.OK, "查询成功！", problem);
            }
        } else {
            return new Result(true, StatusCode.OK, "查询成功！", problem);
        }
        return new Result(false, StatusCode.ERROR, "查询失败，请检查参数是否正确！");
    }


    /**
     * 分页+多条件查询
     *
     * @param problem 查询条件封装
     * @param page    页码
     * @param size    页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    @ApiOperation(value = "分页多条件查询", notes = "分页多条件查询", produces = "application/json")
    public Result findSearch(@RequestBody Problem problem, @PathVariable Integer page, @PathVariable Integer size) {
        EntityWrapper<Problem> ew = new EntityWrapper<>();
        //默认值为第一页
        if (page <= 0) {
            page = 1;
        }
        //默认每页显示两条数据
        if (null == size) {
            size = 2;
        }

        // 1.判断problem是否为空，不为空添加查询条件,为空查询全部
        if (null != problem) {
            if (null != problem.getTitle() && "" != problem.getTitle()) {
                ew.like("title", problem.getTitle());
            }
            if (null != problem.getContent() && "" != problem.getContent()) {
                ew.like("content", problem.getContent());
            }
            if (null != problem.getSolve() && "" != problem.getSolve()) {
                ew.eq("solve", problem.getSolve());
            }
        }
        // 2.查询
        // 2.1设置分页信息，包括当前页和每页显示数量
        PageHelper.startPage(page, size);
        // 2.2执行查询
        List<Problem> problemList = problemService.pageQuery(ew);
        if (null == problemList || problemList.isEmpty()) {
            return new Result(false, StatusCode.ERROR, "查询失败！没有记录！");
        }
        // 2.3获得分页查询后的数据
        PageInfo<Problem> pageInfo = new PageInfo<>(problemList);
        // 2.4封装需要返回的分页实体
        PageResult<Problem> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

        return new Result(true, StatusCode.OK, "查询成功！", pageResult);
    }

    /**
     * 根据条件查询
     *
     * @param problem
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "根据条件查询", notes = "根据条件查询", produces = "application/json")
    public Result findSearch(@RequestBody Problem problem) {
        List<Problem> search = problemService.findSearch(problem);
        if (null != search && !search.isEmpty()) {
            return new Result(true, StatusCode.OK, "查询成功！", search);
        } else {
            return new Result(false, StatusCode.ERROR, "查询失败！");
        }
    }

    /**
     * 增加
     *
     * @param problem
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "增加", notes = "增加", produces = "application/json")
    public Result add(@RequestBody Problem problem) {
        problemService.add(problem);
        return new Result(true, StatusCode.OK, "新增成功！");
    }

    /**
     * 修改
     *
     * @param problem
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "修改", notes = "修改", produces = "application/json")
    public Result update(@RequestBody Problem problem) {
        redisTemplate.delete("problem" + problem.getId());
        problemService.update(problem);
        return new Result(true, StatusCode.OK, "修改成功！");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "删除", produces = "application/json")
    public Result delete(@PathVariable String id) {
        redisTemplate.delete(id);
        problemService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功！");
    }

}
