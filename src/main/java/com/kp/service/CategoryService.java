package com.kp.service;

import com.kp.domain.Category;

import java.util.List;

public interface CategoryService {
    //插入标签
    public boolean insertCategory(Category category);
    //删除标签
    public boolean deleteCategory(List<String> list);
    //更新标签
    public boolean updateCategory(Category category);
    //后台查找类型、文章数量
    public List<Category> findBackCategory();
    //查找所有类型
    public List<Category> findCategory();
}
