package com.kp.dao;

import com.kp.domain.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

//@ContextConfiguration("classpath:springmvc.xml")
//@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:applicationContext.xml")
public class DaoTest {

    @Autowired
    private ArticleDao articleDao;

    //@Test//Caused by: java.lang.IllegalStateException: SpringJUnit4ClassRunner requires JUnit 4.12 or higher.
    public void ArticleTest(){
        List<Article> list = articleDao.findAllArticle();
        for (Article article : list) {
            System.out.println(article);
        }
    }

    @Test
    public void ArticleTest2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArticleDao articleDao = ctx.getBean("articleDao", ArticleDao.class);
        articleDao.findAllArticle();
    }
}
