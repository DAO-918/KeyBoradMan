package com.kp.service.impl;

import com.kp.dao.CategoryDao;
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
    public List<Category> findCategory() {
        List<Category> categoryList = categoryDao.findCategory();
        return categoryList;
    }
}
