package com.kp.service.Impl;

import com.kp.dao.ArticleTagDao;
import com.kp.domain.ArticleTag;
import com.kp.domain.Category;
import com.kp.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagServiceImpl implements ArticleTagService {
    @Autowired
    private ArticleTagDao articleTagDao;
    @Override
    public List<ArticleTag> listArticleTag(Category category) {
        List<ArticleTag> articleTags = articleTagDao.listArticleTag(category);
        return articleTags;
    }
}
