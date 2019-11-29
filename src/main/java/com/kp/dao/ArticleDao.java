package com.kp.dao;

import com.kp.domain.Article;
import com.kp.domain.User;

import java.util.List;

public interface ArticleDao {

    //获取所有文章和文章所属标签、作者
    List<Article> findAllArticle();


    /**
     * 删除文章
     */

    void deleteById(Integer articleId);


    /**
     * 修改文章
     */
    Integer updateArticle(Article article);

    /**
     * 根据userid查询个人文章
     */

    List<Article> findById(Integer id);


    /**
     * 模糊查询搜索功能
     */
    List<Article> findByArticleList(Article article);

}
