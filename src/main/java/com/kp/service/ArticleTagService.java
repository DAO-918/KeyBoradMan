package com.kp.service;

import com.kp.domain.ArticleTag;
import com.kp.domain.BackTag;

import java.util.List;

public interface ArticleTagService {
    public boolean insertTag(ArticleTag articleTag);
    public boolean deleteTag(int id);
    public boolean updateTag(ArticleTag articleTag);
    //后台获取所有标签及类型、类型说明、类型id
    public List<BackTag> findAllTag();
}
