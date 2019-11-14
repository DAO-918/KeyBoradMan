package com.kp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.Article;
import com.kp.domain.Msg;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/delete/{id}")
    public void deleteId(@PathVariable("id") Integer articleId){
        System.out.println("进行删除操作");
        articleService.deleteId(articleId);
    }



}
