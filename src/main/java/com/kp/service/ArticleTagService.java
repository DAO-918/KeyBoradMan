package com.kp.service;

import com.kp.domain.Article_tag;

import java.util.List;

public interface ArticleTagService {
    /**
     * 查询所有标签
     */
    List<Article_tag> findArticle_tagAll();

    /**
     * 添加标签
     */
    void saveArticleTag(Article_tag article_tag);
    /**
     * 删除标签
     */
    void deleteTag(Integer articleTagId);
}
