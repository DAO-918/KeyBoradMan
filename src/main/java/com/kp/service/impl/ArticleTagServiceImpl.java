package com.kp.service.impl;

import com.kp.dao.ArticleTagDao;
import com.kp.domain.Article_tag;
import com.kp.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagServiceImpl implements ArticleTagService {

    @Autowired
    private ArticleTagDao articleTagDao;

    @Override
    public List<Article_tag> findArticle_tagAll() {
        System.out.println("进入service层");
        List<Article_tag> article_tagAll = articleTagDao.findArticle_tagAll();
        return article_tagAll;
    }

    @Override
    public void saveArticleTag(Article_tag article_tag) {
        articleTagDao.saveArticleTag(article_tag);
    }

    @Override
    public void deleteTag(Integer articleTagId) {
        articleTagDao.deleteTag(articleTagId);
    }
}
