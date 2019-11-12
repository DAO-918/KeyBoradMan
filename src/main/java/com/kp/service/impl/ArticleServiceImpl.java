package com.kp.service.impl;

import com.kp.dao.ArticleDao;
import com.kp.domain.Article;
import com.kp.domain.BackArticle;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> findAllArticle() {
        return articleDao.findAllArticle();
    }

    @Override
    public List<BackArticle> findBackAllArticle() {
        return articleDao.findBackAllArticle();
    }
}
