package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 吐槽模块服务接口
 * @author: caipeng
 * @create: 2019-04-15 10:18
 */
@RestController("/spit")
@Api(value = "吐槽Controller", description = "吐槽服务接口")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询全部记录
     *
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询全部记录", notes = "查询全部记录", produces = "application/json")
    public Result findAll() {
        List<Spit> spits = spitService.findAll();
        if (spits.size() > 0 && null != spits) {
            return new Result(true, StatusCode.OK, "查询成功！", spits);
        }
        return new Result(false, StatusCode.ERROR, "查询失败！");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/findone/{id}")
    @ApiOperation(value = "根据id查询", notes = "根据id查询", produces = "application/json")
    public Result findOne(@PathVariable String id) {
        Spit spit = spitService.findOne(id);
        if (null != spit) {
            return Result.success(spit);
        }
        return Result.failure();
    }


    /**
     * 添加
     *
     * @param spit
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加", notes = "添加", produces = "application/json")
    public Result add(@RequestBody Spit spit) {
        spitService.add(spit);
        return Result.success();
    }


    /**
     * 修改
     *
     * @param id
     * @param spit
     * @return
     */
    @PutMapping("/update/{id}")
    @ApiOperation(value = "修改", notes = "根据id修改", produces = "application/json")
    public Result updata(@PathVariable String id, @RequestBody Spit spit) {
        spit.set_id(id);
        spitService.update(spit);
        return Result.success();
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除", notes = "根据id删除", produces = "application/json")
    public Result delete(@PathVariable String id) {
        spitService.deleteById(id);
        return Result.success();
    }


    /**
     * 根据上级id查询吐槽分页数据
     *
     * @param id
     * @return
     */
    @GetMapping("/update/parentid/{parentid}/{page}/{size}")
    @ApiOperation(value = "根据上级id查询吐槽分页数据", notes = "根据上级id查询吐槽分页数据")
    public Result findByParentId(@PathVariable("parentid") String id, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Spit> spits = spitService.findByParentId(id, page, size);
        if (null != spits) {
            return Result.success(new PageResult<Spit>(spits.getTotalElements(), spits.getContent()));
        }
        return Result.failure();
    }


    /**
     * 点赞
     *
     * @param id
     * @return
     */
    @PutMapping("/updateThumbup/{id}")
    @ApiOperation(value = "点赞", notes = "根据id点赞")
    public Result updateThumbup(String id) {
        //判断用户是否点过赞
        String userid = "2333";
        if (redisTemplate.opsForValue().get("thumbup_" + userid + "_" + id) != null) {
            return new Result(false, StatusCode.ERROR, "你已经点过赞了");
        }

        spitService.updateThumbup(id);
        redisTemplate.opsForValue().set("thumbup_" + userid + "_" + id, 1);
        return new Result(true, StatusCode.OK, "点赞成功！");
    }


}
