package com.kp.dao;

import com.kp.domain.Category;

import java.util.List;

public interface CategoryDao {
    //查找所有类型
    public List<Category> findCategory();
}
