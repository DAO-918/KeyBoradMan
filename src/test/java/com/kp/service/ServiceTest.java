package com.kp.service;

import com.kp.domain.Article;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {
    @Test
    public void ArticleTest2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArticleService articleService = ctx.getBean( ArticleService.class);
        List<Article> list = articleService.findAllArticle();
        for (Article article : list) {
            System.out.println(article);
        }
    }
}
