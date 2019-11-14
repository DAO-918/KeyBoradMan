package com.kp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.Article_tag;
import com.kp.domain.Msg;
import com.kp.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ArticleTagController {
    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 分页显示标签表,引入分页插件PageHel
     * @param pageNo
     * @return
     */
    @GetMapping("/all")
    public Msg getArticleTagAll(Integer pageNo){

        System.out.println("进入分页controller层");
        //分页查询
        PageHelper.startPage(pageNo,8);

        List<Article_tag> article_tagAll = articleTagService.findArticle_tagAll();
        //封装 参数指定显示页码
        PageInfo pageInfo = new PageInfo(article_tagAll, 5);
        return Msg.sucess().add("pageInfo",pageInfo);

    }

    /**
     *删除标签
     * @param id
     * @return
     */
    @DeleteMapping("/deletetag/{id}")
    public Msg deleteTag(@PathVariable("id") Integer id){
        System.out.println("标签的编号"+id);
        articleTagService.deleteTag(id);
        return Msg.sucess();
    }
    /**
     * 添加标签
     */
    @PostMapping("/insertArticleTag")
    public Msg saveArticleTag(Article_tag article_tag){

        articleTagService.saveArticleTag(article_tag);
        return Msg.sucess();
    }


}
