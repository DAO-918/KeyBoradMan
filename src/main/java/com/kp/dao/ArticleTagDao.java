package com.kp.dao;

import com.kp.domain.Article_tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**标签表
 * @author Administrator
 */

@Repository
public interface ArticleTagDao {
    /**
     * 获取列表
     */
    List<Article_tag> findArticle_tagAll();

    /**
     * 添加标签
     */
    void saveArticleTag(Article_tag article_tag);

    /**
     * 删除标签
     */
    void deleteTag(Integer articleTagId);

}
