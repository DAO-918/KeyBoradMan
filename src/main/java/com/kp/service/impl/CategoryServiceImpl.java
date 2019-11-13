package com.kp.service.impl;

import com.kp.dao.CategoryDao;
import com.kp.domain.Category;
import com.kp.service.CategoryService;
import com.kp.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public boolean insertCategory(Category category) {
        int i = categoryDao.insertCategory(category);
        return Common.isCUR(i);
    }

    @Override
    public boolean deleteCategory(List<String> list) {
        int i = categoryDao.deleteCategory(list);
        return Common.isDelete(i);
    }

    @Override
    public boolean updateCategory(Category category) {
        int i = categoryDao.updateCategory(category);
        return Common.isCUR(i);
    }

    @Override
    public List<Category> findBackCategory() {
        List<Category> categoryList = categoryDao.findCategory();
        return categoryList;
    }

    @Override
    public List<Category> findCategory() {
        List<Category> categoryList = categoryDao.findCategory();
        return categoryList;
    }
}
