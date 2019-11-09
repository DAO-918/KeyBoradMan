package com.kp.dao;

import com.kp.domain.Article;

import java.util.List;

public interface ArticleDao {

    //获取所有文章和文章所属标签、作者
    List<Article> findAllArticle();
}
