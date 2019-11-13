package com.kp.dao;

import com.kp.domain.Article;
import com.kp.domain.Comment;
import com.kp.domain.CommentVo;
import com.kp.domain.GreatArticle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    //获取所有文章和文章所属标签、作者
    List<Article> findAllArticle();

    //根据文章id获取文章信息
    Article findArticleById(Integer art_id);

    //获取文章评论列表
    List<Comment> listComment(Integer art_id);


    //获取用户点赞文章关系表信息
    GreatArticle findGreatArticle(GreatArticle greatArticle);

    //保存文章点赞信息
    void saveGreatArticle(GreatArticle greatArticle);

    //点赞加一
    void addArtlike(Integer ga_art_id);

    //点赞减一
    void decArtlike(Integer ga_art_id);

    //更新啊评论点赞表点赞标志
    void updateGreatArticle(GreatArticle greatArticle1);

    ////根据标签名获取文章列表
    List<Article> findArticleByTagName(String tag_name);
}
