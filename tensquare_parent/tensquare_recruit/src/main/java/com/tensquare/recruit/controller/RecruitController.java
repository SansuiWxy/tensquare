package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 职位招聘controller
 * @author: caipeng
 * @create: 2019-04-11 10:58
 */
@RestController(value = "/recruit")
@Api(value = "职位招聘controller", description = "职位招聘服务接口")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;


    /**
     * 新增招聘
     *
     * @param recruit
     * @return
     */
    @ApiOperation(value = "新增招聘", notes = "新增招聘", produces = "application/json")
    @PostMapping("/addRecruit")
    public Result addRecruit(@RequestBody Recruit recruit) {
        if (null == recruit) {
            return new Result(false, StatusCode.ERROR, "数据格式错误，新增失败！");
        }
        boolean flag = recruitService.saveRecruit(recruit);
        if (flag) {
            return new Result(true, StatusCode.OK, "添加成功! ");
        }
        return new Result(false, StatusCode.ERROR, "新增失败! ");
    }


    /**
     * 招聘全部列表
     *
     * @return
     */
    @GetMapping("/allList")
    @ApiOperation(value = "招聘全部列表", notes = "招聘全部列表", produces = "application/json")
    public Result allRecruit() {
        List<Recruit> recruitList = recruitService.allRecruit();
        if (null != recruitList && recruitList.size() > 0) {
            return new Result(true, StatusCode.OK, "查询成功！", recruitList);
        }
        return new Result(false, StatusCode.ERROR, "查询失败！");

    }

    /**
     * 推荐职位列表
     *
     * @return
     */
    @GetMapping("/search/recommend")
    @ApiOperation(value = "推荐职位列表", notes = "根据是否推荐状态查询前4位，并按时间降序", produces = "application/json")
    public Result recommendRecruit() {
        List<Recruit> recruitList = recruitService.findTop4ByStatesOrderByCreatetimeDesc("2");
        if (null != recruitList && !recruitList.isEmpty()) {
            return new Result(true, StatusCode.OK, "查询成功！", recruitList);
        }
        return new Result(false, StatusCode.ERROR, "查询失败！");
    }

    /**
     * 查询状态不为0并以创建日期降序排序，查询前12条记录
     *
     * @return
     */
    @GetMapping("/search/newRecruitList")
    @ApiOperation(value = "最新职位列表", notes = "查询状态不为0并以创建日期降序排序，查询前12条记录  state: 0：关闭 1:开启 2：推荐", produces = "application/json")
    public Result newRecruitList() {
        //查询状态不为0的职位信息
        List<Recruit> newRecruitList = recruitService.findNewRecruit("0");
        if (null != newRecruitList && !newRecruitList.isEmpty()) {
            return new Result(true, StatusCode.OK, "查询成功！", newRecruitList);
        }
        return new Result(false, StatusCode.ERROR, "查询失败！");
    }

}
