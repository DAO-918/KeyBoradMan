package com.kp.service;

import com.kp.domain.Article;

import java.util.List;

public interface ArticleService {
    //获取所有文章和文章所属标签、作者
    List<Article> findAllArticle();
}
