package com.kp.service;

import com.kp.domain.ArticleTag;
import com.kp.domain.Category;

import java.util.List;

public interface CategoryService {
    List<ArticleTag> searchCategory(Category category);

    List<Category> search();
}
