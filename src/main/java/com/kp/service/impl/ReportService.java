package com.kp.service.impl;

import com.kp.dao.ArticleDao;
import com.kp.dao.ArticleTagDao;
import com.kp.dao.CategoryDao;
import com.kp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService implements com.kp.service.ReportService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleTagDao articleTagDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, Integer> BackMainPageInfo() {
        Map<String,Integer> map = new HashMap<>();
        int count1 = articleDao.getTotalArticleConunt();
        int count2 = articleTagDao.getTotalTagConunt();
        int count3 = categoryDao.getTotalCategoryConunt();
        int count4 = userDao.getTotalUserConunt();
        map.put("articleCount",count1);
        map.put("tagCount",count2);
        map.put("categoryCount",count3);
        map.put("userCount",count4);
        return map;
    }
}
