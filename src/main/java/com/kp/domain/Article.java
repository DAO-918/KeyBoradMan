package com.kp.domain;

import java.util.Date;
import java.util.List;

public class Article {
    private Integer art_id;
    private Integer art_user_id;
    private String art_title;
    private Integer art_tag_id;
    private Integer art_category_id;
    private String art_content;
    private Date art_create_time;
    private Integer art_com_num;
    private Integer art_hot_num;
    private Integer art_like_num;

    //多对一关系，多篇文章可以对应同个标签
    private Article_tag article_tag;

    //多对一关系，多篇文章对应一个作者
    private User user;

    @Override
    public String toString() {
        return "Article{" +
                "art_id=" + art_id +
                ", art_user_id=" + art_user_id +
                ", art_title='" + art_title + '\'' +
                ", art_tag_id=" + art_tag_id +
                ", art_category_id=" + art_category_id +
                ", art_content='" + art_content + '\'' +
                ", art_create_time=" + art_create_time +
                ", art_com_num=" + art_com_num +
                ", art_hot_num=" + art_hot_num +
                ", art_like_num=" + art_like_num +
                ", article_tag=" + article_tag +
                ", user=" + user +
                '}';
    }

    public Integer getArt_id() {
        return art_id;
    }

    public void setArt_id(Integer art_id) {
        this.art_id = art_id;
    }

    public Integer getArt_user_id() {
        return art_user_id;
    }

    public void setArt_user_id(Integer art_user_id) {
        this.art_user_id = art_user_id;
    }

    public String getArt_title() {
        return art_title;
    }

    public void setArt_title(String art_title) {
        this.art_title = art_title;
    }

    public Integer getArt_tag_id() {
        return art_tag_id;
    }

    public void setArt_tag_id(Integer art_tag_id) {
        this.art_tag_id = art_tag_id;
    }

    public Integer getArt_category_id() {
        return art_category_id;
    }

    public void setArt_category_id(Integer art_category_id) {
        this.art_category_id = art_category_id;
    }

    public String getArt_content() {
        return art_content;
    }

    public void setArt_content(String art_content) {
        this.art_content = art_content;
    }

    public Date getArt_create_time() {
        return art_create_time;
    }

    public void setArt_create_time(Date art_create_time) {
        this.art_create_time = art_create_time;
    }

    public Integer getArt_com_num() {
        return art_com_num;
    }

    public void setArt_com_num(Integer art_com_num) {
        this.art_com_num = art_com_num;
    }

    public Integer getArt_hot_num() {
        return art_hot_num;
    }

    public void setArt_hot_num(Integer art_hot_num) {
        this.art_hot_num = art_hot_num;
    }

    public Integer getArt_like_num() {
        return art_like_num;
    }

    public void setArt_like_num(Integer art_like_num) {
        this.art_like_num = art_like_num;
    }

    public Article_tag getArticle_tag() {
        return article_tag;
    }

    public void setArticle_tag(Article_tag article_tag) {
        this.article_tag = article_tag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
