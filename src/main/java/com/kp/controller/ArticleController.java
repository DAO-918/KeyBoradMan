package com.kp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.Article;
import com.kp.domain.Msg;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@RestController注解相当于@ResponseBody + @Controller
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public Msg getListArticle(Integer pageNo){
        //这是一个分页查询
        //引入PageHelp分页插件
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNo,1);//自动添加limit 0,8
        //startPage后面紧跟的查询就是分页查询
        List<Article> allArticle = articleService.findAllArticle();
        System.out.println(allArticle);
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        //封装了详细的分页信息,传入连续显示的页数
        PageInfo pageInfo=new PageInfo(allArticle,4);
        return Msg.sucess().add("pageInfo",pageInfo);
    }
}