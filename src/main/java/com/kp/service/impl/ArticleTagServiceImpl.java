package com.kp.service.impl;

import com.kp.dao.ArticleTagDao;
import com.kp.domain.ArticleTag;
import com.kp.domain.BackTag;
import com.kp.service.ArticleTagService;
import com.kp.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagServiceImpl implements ArticleTagService {
    @Autowired
    private ArticleTagDao articleTagDao;

    @Override
    public boolean insertTag(ArticleTag articleTag) {
        int i = articleTagDao.insertTag(articleTag);
        return Common.isCUR(i);
    }

    @Override
    public boolean deleteTag(List<String> list) {
        int i = articleTagDao.deleteTag(list);
        return Common.isDelete(i);
    }

    @Override
    public boolean updateTag(ArticleTag articleTag) {
        int i = articleTagDao.updateTag(articleTag);
        return Common.isCUR(i);
    }

    @Override
    public boolean findBackTagByNameCount(String tag_name) {
        int i = articleTagDao.findBackTagByNameCount(tag_name);
        return Common.isCUR(i);
    }

    @Override
    public List<BackTag> findBackTag() {
        List<BackTag> tagList = articleTagDao.findBackTag();
        return tagList;
    }


    public List<ArticleTag> findArticle_tagAll() {
        System.out.println("进入service层");
        List<ArticleTag> article_tagAll = articleTagDao.findArticle_tagAll();
        return article_tagAll;
    }

    @Override
    public void saveArticleTag(ArticleTag article_tag) {
        articleTagDao.saveArticleTag(article_tag);
    }

    @Override
    public void deleteTag2(Integer articleTagId) {
        articleTagDao.deleteTag2(articleTagId);
    }
}
