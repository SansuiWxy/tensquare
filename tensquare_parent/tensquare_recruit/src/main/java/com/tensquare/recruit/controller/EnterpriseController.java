package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 企业controller
 * @author: caipeng
 * @create: 2019-04-10 17:50
 */
@RestController("/enterprise")
@Api(value = "企业controller", description = "企业微服务接口")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 热门企业列表
     *
     * @return
     */
    @ApiOperation(value = "热门企业列表", notes = "热门企业列表", produces = "application/json")
    @GetMapping("/search/hotlist")
    public Result hotList() {
        List<Enterprise> enterpriseList = enterpriseService.hotlist();
        if (enterpriseList != null) {
            return new Result(true, StatusCode.OK, "查询成功！", enterpriseList);
        }
        return new Result(false, StatusCode.ERROR, "查询失败！");
    }
}
