package com.kp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.ArticleTag;
import com.kp.domain.BackTag;
import com.kp.domain.Msg;
import com.kp.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleTagController {

    @Autowired
    private ArticleTagService articleTagService;

    @RequestMapping(value="/insertTag", method= RequestMethod.PUT)
    public Msg insertTag(ArticleTag articleTag){
        boolean flag = articleTagService.insertTag(articleTag);
        return Msg.sucess().add("msg","添加标签操作成功").add("flag",flag);
    }

    @RequestMapping(value="/deleteTag", method= RequestMethod.DELETE)
    public Msg deleteTag(int del_id){
        boolean flag = articleTagService.deleteTag(del_id);
        return Msg.sucess().add("msg","删除标签操作成功").add("flag",flag);
    }

    @RequestMapping(value="/updateTag", method= RequestMethod.POST)
    public Msg updateTag(ArticleTag articleTag){
        boolean flag = articleTagService.updateTag(articleTag);
        return Msg.sucess().add("msg","更新标签操作成功").add("flag",flag);
    }

    @RequestMapping(value="/tag", method= RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String getBackListTag(int pageNumber, int pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        List<BackTag> tagList = articleTagService.findAllTag();
        PageInfo pageInfo = new PageInfo(tagList);
        JSONObject result = new JSONObject();
        result.put("total", pageInfo.getTotal());
        result.put("rows", pageInfo.getList());
        return result.toJSONString();
    }
}
