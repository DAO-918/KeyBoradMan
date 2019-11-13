package com.kp.service.impl;

import com.kp.dao.CommentMultiDao;
import com.kp.domain.BackCommentMulti;
import com.kp.domain.CommentMulti;
import com.kp.service.CommentMultiService;
import com.kp.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentMultiServiceImpl implements CommentMultiService {

    @Autowired
    private CommentMultiDao commentMultiDao;

    @Override
    public boolean deleteCommentMulti(List<String> list) {
        int i = commentMultiDao.deleteCommentMulti(list);
        return Common.isDelete(i);
    }

    @Override
    public List<BackCommentMulti> findBackCommentMulitiByCid(int comment_id) {
        List<BackCommentMulti> commentMultiList = commentMultiDao.findBackCommentMulitiByCid(comment_id);
        return commentMultiList;
    }

    @Override
    public List<CommentMulti> findCommentMuliti() {
        List<CommentMulti> commentMultiList = commentMultiDao.findCommentMuliti();
        return commentMultiList;
    }
}
