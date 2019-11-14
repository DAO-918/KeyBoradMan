package com.kp.service;

import com.kp.domain.ArticleTag;
import com.kp.domain.BackTag;

import java.util.List;

public interface ArticleTagService {
    //插入标签
    public boolean insertTag(ArticleTag articleTag);
    //删除标签
    public boolean deleteTag(List<String> list);
    //更新标签
    public boolean updateTag(ArticleTag articleTag);
    //根据名称搜索
    public boolean findBackTagByNameCount(String tag_name);
    //后台获取所有标签及类型、类型说明、类型id
    public List<BackTag> findBackTag();


    /**许炳海
     * 查询所有标签
     */
    List<ArticleTag> findArticle_tagAll();

    /**
     * 添加标签
     */
    void saveArticleTag(ArticleTag article_tag);
    /**
     * 删除标签
     */
    void deleteTag2(Integer articleTagId);
}
