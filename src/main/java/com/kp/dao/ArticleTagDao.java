package com.kp.dao;

import com.kp.domain.ArticleTag;
import com.kp.domain.BackTag;

import java.util.List;

public interface ArticleTagDao {

    public int insertTag(ArticleTag articleTag);
    public int deleteTag(int id);
    public int updateTag(ArticleTag articleTag);
    //后台获取所有标签及类型、类型说明、类型id
    public List<BackTag> findAllTag();
}
