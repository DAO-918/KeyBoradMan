package com.kp.service;

import com.kp.domain.*;

import java.util.List;

public interface ArticleService {
    //获取所有文章和文章所属标签、作者
    List<Article> findAllArticle();

    Article findArticleById(Integer art_id);

    List<Comment> listComment(Integer art_id);

    //获取用户点赞文章关系表信息
    Article findGreatArticle(GreatArticle greatArticle);

    GreatArticle findGAStatus(GreatArticle greatArticle);

    //根据标签名获取文章列表
    List<Article> findArticleByTagName(String tag_name,String keyboard);

    //增加一篇文章
    void saveArticle(Article article);

    List<Article> listArtTitle();

    List<Article> searchArtTitle();
}
