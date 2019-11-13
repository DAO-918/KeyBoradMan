package com.kp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.*;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        PageHelper.startPage(pageNo,1);//自动添加limit 0,8
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
        PageInfo pageInfo=new PageInfo(allArticle,4);
        Msg pageInfo1 = msg.sucess().add("pageInfo", pageInfo);
        pageInfo1.setTime(msg.getTime());
        return pageInfo1;
    }

    @GetMapping("/articleById")
    public Article findById(Integer art_id){
        Article articleById = articleService.findArticleById(art_id);
        return articleById;
    }

    @GetMapping("/articleByTarName")
    public Msg listArticleBytagName(Integer pageNo,String tag_name) throws ParseException {
        //这是一个分页查询
        //引入PageHelp分页插件
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNo,1);//自动添加limit 0,8
        //startPage后面紧跟的查询就是分页查询
        List<Article> articleByTagName = articleService.findArticleByTagName(tag_name);
        //date类毫秒值转时间字符串
        Msg msg = new Msg();
        for (Article article : articleByTagName) {
            Date art_create_time = article.getArt_create_time();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(art_create_time);
            msg.setTime(format);
        }
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        //封装了详细的分页信息,传入连续显示的页数
        PageInfo pageInfo=new PageInfo(articleByTagName,4);
        Msg pageInfo1 = msg.sucess().add("pageInfo", pageInfo);
        pageInfo1.setTime(msg.getTime());
        return pageInfo1;
    }

    @GetMapping("/comment")
    public Msg listComment(Integer pageNo,Integer art_id){
        //这是一个分页查询
        //引入PageHelp分页插件
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNo,1);//自动添加limit 0,8
        //startPage后面紧跟的查询就是分页查询
        List<Comment> commentList = articleService.listComment(art_id);
        //date类毫秒值转时间字符串
        Msg msg = new Msg();
        for (Comment comment : commentList) {
            Date com_time = comment.getCom_time();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(com_time);
            msg.setTime(format);
        }
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        //封装了详细的分页信息,传入连续显示的页数
        PageInfo pageInfo=new PageInfo(commentList,3);
        Msg pageInfo1 = msg.sucess().add("pageInfo", pageInfo);
        pageInfo1.setTime(msg.getTime());
        return pageInfo1;
    }

    @GetMapping("greatArticle")
    public  Article greatArticle(Integer art_id,Integer user_id){
        GreatArticle greatArticle = new GreatArticle();
        greatArticle.setGa_art_id(art_id);
        greatArticle.setGa_user_id(user_id);
        Article article = articleService.findGreatArticle(greatArticle);
        return article;
    }

    @GetMapping("great")
    public GreatArticle findGAStatus(Integer art_id,Integer user_id){
        GreatArticle greatArticle = new GreatArticle();
        greatArticle.setGa_art_id(art_id);
        greatArticle.setGa_user_id(user_id);
        return articleService.findGAStatus(greatArticle );
    }
}
