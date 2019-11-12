package com.kp.service;

import com.kp.domain.Category;

import java.util.List;

public interface CategoryService {
    //查找所有类型
    public List<Category> findCategory();
}
