package com.kp.dao;

import com.kp.domain.Category;

import java.util.List;

public interface CategoryDao {
    //插入标签
    public int insertCategory(Category category);
    //删除标签
    public int deleteCategory(List<String> list);
    //更新标签
    public int updateCategory(Category category);
    //后台查找类型、文章数量
    //public
    //查找所有类型
    public List<Category> findCategory();
    //后台统计类型数量
    int getTotalCategoryConunt();
    //查看类型是否存在
    public int findBackCategoryByNameCount(String category_name);

}
