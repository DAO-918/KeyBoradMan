package com.kp.service.impl;

import com.kp.dao.ArticleDao;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleDao articleDao;

    @Override
    public int findArticleCount(Integer uid) {
        return articleDao.findArticleCount(uid);
    }
}
