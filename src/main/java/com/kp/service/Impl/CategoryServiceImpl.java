package com.kp.service.Impl;

import com.kp.dao.CategoryDao;
import com.kp.domain.ArticleTag;
import com.kp.domain.Category;
import com.kp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<ArticleTag> searchCategory(Category category) {
        List<ArticleTag> articleTags = categoryDao.searchCategory(category);
        return articleTags;
    }

    @Override
    public List<Category> search() {
        List<Category> search = categoryDao.search();
        return search;
    }
}
