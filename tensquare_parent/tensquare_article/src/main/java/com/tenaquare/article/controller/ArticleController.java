package com.tenaquare.article.controller;

import com.tenaquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 文章模块controller
 * @author: caipeng
 * @create: 2019-04-12 18:26
 */
@RestController("/article")
@Api(value = "文章模块服务接口", description = "文章模块服务接口")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章审核
     *
     * @param id
     * @return
     */
    @PutMapping("/examine/{id}")
    @ApiOperation(value = "文章审核", notes = "根据id审核文章", produces = "application/json")
    public Result examine(Long id) {
        Boolean flag = articleService.examine(id);
        if (flag) {
            return new Result(true, StatusCode.OK, "审核成功");
        }
        return new Result(false, StatusCode.ERROR, "审核失败");

    }


}
