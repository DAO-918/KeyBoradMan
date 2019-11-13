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
    public List<BackTag> findBackTag() {
        List<BackTag> tagList = articleTagDao.findBackTag();
        return tagList;
    }

}
