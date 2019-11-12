package com.kp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.ArticleTag;
import com.kp.domain.BackTag;
import com.kp.domain.Msg;
import com.kp.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class ArticleTagController {

    @Autowired
    private ArticleTagService articleTagService;

    @RequestMapping(value="/", method= RequestMethod.PUT)
    public Msg insertTag(ArticleTag articleTag){
        boolean flag = articleTagService.insertTag(articleTag);
        return Msg.sucess().add("msgInfo","添加标签操作成功").add("flag",flag);
    }

    @RequestMapping(value="/", method= RequestMethod.DELETE)
    public Msg deleteTag(String delIds){
        String[] Ids = delIds.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(Ids));
        boolean flag = articleTagService.deleteTag(list);
        return Msg.sucess().add("msgInfo","删除标签操作成功").add("flag",flag);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.POST)
    public Msg updateTag(@PathVariable Integer id, ArticleTag articleTag){
        System.out.println("---------"+id+"---------");
        boolean flag = articleTagService.updateTag(articleTag);
        return Msg.sucess().add("msgInfo","更新标签操作成功").add("flag",flag);
        //{"code":100,"message":"处理成功","time":null,"extend":{"flag":true,"msgInfo":"更新标签操作成功"}}
    }

    @RequestMapping(value="/", method= RequestMethod.GET,produces = "application/json;charset=UTF-8")
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
