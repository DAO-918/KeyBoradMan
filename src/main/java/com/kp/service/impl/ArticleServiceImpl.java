package com.kp.service.impl;

import com.kp.dao.ArticleDao;
import com.kp.domain.*;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> findAllArticle() {
        return articleDao.findAllArticle();
    }

    @Override
    public Article findArticleById(Integer art_id) {
        return articleDao.findArticleById(art_id);
    }

    @Override
    public List<Comment> listComment(Integer art_id) {
        return articleDao.listComment(art_id);
    }

    @Override
    public Article findGreatArticle(GreatArticle greatArticle) {
        GreatArticle greatArticle1 = articleDao.findGreatArticle(greatArticle);

        //如果不存在点赞关系，则存入数据库，且点赞加1，存在则取消点赞
        if (greatArticle1==null){
            greatArticle.setGa_status(1);
            articleDao.saveGreatArticle(greatArticle);
            //点赞数量加一
            articleDao.addArtlike(greatArticle.getGa_art_id());


        }else {
            if (greatArticle1.getGa_status()==0){
                //点赞数量加一
                greatArticle1.setGa_status(1);
                articleDao.updateGreatArticle(greatArticle1);
                articleDao.addArtlike(greatArticle.getGa_art_id());
            } else {
                //点赞数量减一
                greatArticle1.setGa_status(0);
                articleDao.updateGreatArticle(greatArticle1);
                articleDao.decArtlike(greatArticle.getGa_art_id());
            }
        }

        Article articleById = articleDao.findArticleById(greatArticle.getGa_art_id());
        return articleById;
    }

    @Override
    public GreatArticle findGAStatus(GreatArticle greatArticle) {
        return articleDao.findGreatArticle(greatArticle);
    }

    @Override
    public List<Article> findArticleByTagName(String tag_name,String keyboard) {
        if (tag_name!=null){
            return articleDao.findArticleByTagName(tag_name);
        } else {
            return articleDao.searchArticle(keyboard);
        }

    }

    @Override
    public void saveArticle(Article article) {
        articleDao.saveArticle(article);
    }

    @Override
    public List<Article> listArtTitle() {
        List<Article> articles = articleDao.listArtTitle();
        return articles;
    }

    @Override
    public List<Article> searchArtTitle() {
        List<Article> articles = articleDao.searchArtTitle();
        return articles;
    }
}
