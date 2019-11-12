package com.kp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.Article;
import com.kp.domain.BackArticle;
import com.kp.domain.Msg;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public Msg getListArticle(Integer pageNo) throws ParseException {
        //这是一个分页查询
        //引入PageHelp分页插件
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNo, 1);//自动添加limit 0,8
        //startPage后面紧跟的查询就是分页查询
        List<Article> allArticle = articleService.findAllArticle();
        //date类毫秒值转时间字符串
        Msg msg = new Msg();
        for (Article article : allArticle) {
            Date art_create_time = article.getArt_create_time();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(art_create_time);
            msg.setTime(format);
        }
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        //封装了详细的分页信息,传入连续显示的页数
        PageInfo pageInfo = new PageInfo(allArticle, 4);
        Msg pageInfo1 = msg.sucess().add("pageInfo", pageInfo);
        //pageInfo1.setTime(msg.getTime());
        return pageInfo1;
    }

    //后台获取文章、标签、类型、作者
    @GetMapping(value = "/bcarticle", produces = "application/json;charset=UTF-8")
    public String getBackListArticle(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<BackArticle> articleList = articleService.findBackAllArticle();
        PageInfo pageInfo = new PageInfo(articleList);
        JSONObject result = new JSONObject();
        result.put("total", pageInfo.getTotal());
        result.put("rows", pageInfo.getList());
        return result.toJSONString();
    }
}
