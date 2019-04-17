package com.tensquare.qa.controller;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tensquare.qa.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tensquare.qa.pojo.Reply;

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
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;


    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", replyService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable Long id) {
        return new Result(true, StatusCode.OK, "查询成功", replyService.findById(id));
    }


    /**
     * 分页+多条件查询
     *
     * @param reply 查询条件封装
     * @param page  页码
     * @param size  页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Reply reply, @PathVariable Integer page, @PathVariable Integer size) {
        EntityWrapper<Reply> ew = new EntityWrapper<>();
        //默认值为第一页
        if (page <= 0) {
            page = 1;
        }
        //默认每页显示两条数据
        if (null == size) {
            size = 2;
        }

        // 1.判断reply是否为空，不为空添加查询条件,为空查询全部
        if (null != reply) {
            if (null != reply.getId()) {
                ew.eq("id", reply.getId());
            }
            if (null != reply.getProblemid()) {
                ew.eq("problemid", reply.getProblemid());
            }
            if (null != reply.getContent() && "" != reply.getContent()) {
                ew.eq("content", reply.getContent());
            }
            if (null != reply.getUserid()) {
                ew.eq("userid", reply.getUserid());
            }
            if (null != reply.getNickname() && !"".equals(reply.getNickname())) {
                ew.eq("nickname", reply.getNickname());
            }
        }
        // 2.查询
        // 2.1设置分页信息，包括当前页和每页显示数量
        PageHelper.startPage(page, size);
        // 2.2执行查询
        List<Reply> replyList = replyService.pageQuery(ew);
        if (null == replyList || replyList.isEmpty()) {
            return new Result(false, StatusCode.ERROR, "查询失败！没有记录！");
        }
        // 2.3获得分页查询后的数据
        PageInfo<Reply> pageInfo = new PageInfo<>(replyList);
        // 2.4封装需要返回的分页实体
        PageResult<Reply> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

        return new Result(true, StatusCode.OK, "查询成功！", pageResult);

    }

    /**
     * 根据条件查询
     *
     * @param reply
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Reply reply) {
        return new Result(true, StatusCode.OK, "查询成功", replyService.findSearch(reply));
    }

    /**
     * 增加
     *
     * @param reply
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Reply reply) {
        replyService.add(reply);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param reply
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Reply reply) {
        replyService.update(reply);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable Long id) {
        replyService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
