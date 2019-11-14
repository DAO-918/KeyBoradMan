package com.kp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.ArticleTag;
import com.kp.domain.BackTag;
import com.kp.domain.Msg;
import com.kp.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ArticleTagController {

    @Autowired
    private ArticleTagService articleTagService;

    @RequestMapping(value = "/tag/", method = RequestMethod.PUT)
    public Msg insertTag(ArticleTag articleTag) {
        boolean flag = articleTagService.insertTag(articleTag);
        return Msg.sucess().add("msgInfo", "添加标签操作成功").add("flag", flag);
    }

    @RequestMapping(value = "/tag/", method = RequestMethod.DELETE)
    public Msg deleteTag(String delIds) {
        String[] Ids = delIds.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(Ids));
        boolean flag = articleTagService.deleteTag(list);
        return Msg.sucess().add("msgInfo", "删除标签操作成功").add("flag", flag);
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.POST)
    public Msg updateTag(@PathVariable Integer id, ArticleTag articleTag) {
        System.out.println("---------" + id + "---------");
        boolean flag = articleTagService.updateTag(articleTag);
        return Msg.sucess().add("msgInfo", "更新标签操作成功").add("flag", flag);
        //{"code":100,"message":"处理成功","time":null,"extend":{"flag":true,"msgInfo":"更新标签操作成功"}}
    }

    @RequestMapping(value = "/tag/exist/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Msg isTagExist(String tag_name) {
        boolean flag = articleTagService.findBackTagByNameCount(tag_name);
        String str = flag ? "exist" : "notexist";
        return Msg.sucess().add("resultMsg", str);
    }

    @RequestMapping(value = "/tag/bc/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getBackListTag(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<BackTag> tagList = articleTagService.findBackTag();
        PageInfo pageInfo = new PageInfo(tagList);
        JSONObject result = new JSONObject();
        result.put("total", pageInfo.getTotal());
        result.put("rows", pageInfo.getList());
        return result.toJSONString();

    }

    /**
     * 分页显示标签表,引入分页插件PageHel
     * @param pageNo
     * @return
     */
    @GetMapping("/all")
    public Msg getArticleTagAll (Integer pageNo){

        System.out.println("进入分页controller层");
        //分页查询
        PageHelper.startPage(pageNo, 8);

        List<ArticleTag> article_tagAll = articleTagService.findArticle_tagAll();
        //封装 参数指定显示页码
        PageInfo pageInfo = new PageInfo(article_tagAll, 5);
        return Msg.sucess().add("pageInfo", pageInfo);

    }

    /**
     *删除标签
     * @param id
     * @return
     */
    @DeleteMapping("/deletetag/{id}")
    public Msg deleteTag (@PathVariable("id") Integer id){
        System.out.println("标签的编号" + id);
        articleTagService.deleteTag2(id);
        return Msg.sucess();
    }
    /**
     * 添加标签
     */
    @PostMapping("/insertArticleTag")
    public Msg saveArticleTag (ArticleTag articletag){
        articleTagService.saveArticleTag(articletag);
        return Msg.sucess();
    }

}
