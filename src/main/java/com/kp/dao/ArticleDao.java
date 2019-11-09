package com.kp.dao;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleDao {

    /**
     * 查询文章数量
     */
    int findArticleCount(Integer uid);
}
