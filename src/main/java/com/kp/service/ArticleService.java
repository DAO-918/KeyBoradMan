package com.kp.service;

import com.kp.domain.Article;
import com.kp.domain.BackArticle;

import java.util.List;

public interface ArticleService {
    //获取所有文章和文章所属标签、作者
    List<Article> findAllArticle();

    //后台获取文章、标签、类型、作者
    List<BackArticle> bcfindAllArticle();
}
