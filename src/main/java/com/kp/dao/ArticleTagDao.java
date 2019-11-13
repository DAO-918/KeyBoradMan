package com.kp.dao;

import com.kp.domain.ArticleTag;
import com.kp.domain.Category;

import java.util.List;

public interface ArticleTagDao {
    List<ArticleTag> listArticleTag(Category category);
}
