package com.kp.service.impl;

import com.kp.dao.ArticleDao;
import com.kp.domain.Article;
import com.kp.domain.BackArticle;
import com.kp.service.ArticleService;
import com.kp.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public boolean deleteBackArticle(List<String> list){
        int i = articleDao.deleteBackArticle(list);
        return Common.isDelete(i);
    }

    @Override
    public List<Article> findAllArticle() {
        return articleDao.findAllArticle();
    }

    @Override
    public List<BackArticle> findBackAllArticle() {
        return articleDao.findBackAllArticle();
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
