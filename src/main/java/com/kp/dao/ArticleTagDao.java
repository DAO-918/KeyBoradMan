package com.kp.dao;

import com.kp.domain.ArticleTag;
import com.kp.domain.BackTag;

import java.util.List;

public interface ArticleTagDao {
    //插入标签
    public int insertTag(ArticleTag articleTag);
    //删除标签
    public int deleteTag(List<String> list);
    //更新标签
    public int updateTag(ArticleTag articleTag);
    //后台获取所有标签及类型、类型说明、类型id
    public List<BackTag> findBackTag();
    //根据名称搜索
    public int findBackTagByNameCount(String tag_name);
    //后台获取所有标签数量
    int getTotalTagConunt();


    /**
     * 许炳海
     * 获取列表
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
