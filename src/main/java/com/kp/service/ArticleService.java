package com.kp.service;

import com.kp.domain.Article;

import java.util.List;

public interface ArticleService {
    //获取所有文章和文章所属标签、作者
    List<Article> findAllArticle();

    /**
     * 删除文章(根据id删除)
     */
    void deleteId(Integer articleId);

    /**
     * 根据id修改文章
     */
    void updateArticle(Article article);

    /**
     * gen根据userid查询个人文章
     * @param id
     */
    List<Article> findById(Integer id);
}
