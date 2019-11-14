package com.kp.service.impl;

import com.kp.dao.ArticleDao;
import com.kp.domain.Article;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> findAllArticle() {
        return articleDao.findAllArticle();
    }

    @Override
    public void deleteId(Integer articleId) {
        articleDao.deleteById(articleId);

    }

    @Override
    public void updateArticle(Article article) {
         articleDao.updateArticle(article);
    }

    /**
     *根据user_id 查询所有个人文章
     * @param id
     */

    @Override
    public List<Article> findById(Integer id) {
        System.out.println("555");
      return  articleDao.findById(id);
    }
}
