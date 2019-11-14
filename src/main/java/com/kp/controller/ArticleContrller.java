package com.kp.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.Article;
import com.kp.domain.Msg;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ArticleContrller {

    @Autowired
    private ArticleService articleService;
    /**
     * 查询个人文章
     * @param
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/userid")
    public Msg selectid(Integer pageNo, Integer user_id){
        System.out.println("是是是");
        //分页查询
        PageHelper.startPage(pageNo,5);
        List<Article> byId = articleService.findById(user_id);
        Msg msg = new Msg();
//        转换日期
        for (Article article : byId) {
            Date art_create_time = article.getArt_create_time();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(art_create_time);
            msg.setTime(format);
        }

        PageInfo pageInfo = new PageInfo(byId,5);

        return Msg.sucess().add("pageInfo",pageInfo);
    }
    /**
     * 根据id删除文章
     */
    @DeleteMapping("/deleteArticle/{id}")
    public Msg deleteArticle(@PathVariable("id") Integer articleId){
        System.out.println("id"+articleId);
        articleService.deleteId(articleId);
        return Msg.sucess();
    }
}
