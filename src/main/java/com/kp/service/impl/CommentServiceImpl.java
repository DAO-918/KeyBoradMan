package com.kp.service.impl;

import com.kp.dao.CommentDao;
import com.kp.domain.BackComment;
import com.kp.service.CommentService;
import com.kp.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public boolean deleteComment(List<String> list) {
        int i = commentDao.deleteComment(list);
        return Common.isDelete(i);
    }

    @Override
    public List<BackComment> findBackComment() {
        List<BackComment> commentList = commentDao.findBackComment();
        return commentList;
    }
}
