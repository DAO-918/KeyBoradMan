package com.kp.service.impl;

import com.kp.dao.ArticleDao;
import com.kp.dao.CommentDao;
import com.kp.domain.Comment;
import com.kp.domain.GreatComment;
import com.kp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment findGreatComment(GreatComment greatComment) {
        GreatComment greatComment1 = commentDao.findGreatComment(greatComment);
        //如果不存在点赞关系，则存入数据库，且点赞加1，存在则取消点赞
        if (greatComment1==null){
            greatComment.setGc_status(1);
            commentDao.saveGreatComment(greatComment);
            //点赞数量加一
            commentDao.addComLike(greatComment.getGc_com_id());

        }else {
            if (greatComment1.getGc_status()==0){
                //点赞数量加一
                greatComment1.setGc_status(1);
                commentDao.updateGreatComment(greatComment1);
                commentDao.addComLike(greatComment1.getGc_com_id());
            } else {
                //点赞数量减一
                greatComment1.setGc_status(0);
                commentDao.updateGreatComment(greatComment1);
                commentDao.decComLike(greatComment1.getGc_com_id());
            }
        }

        return commentDao.findCommentByComId(greatComment.getGc_com_id());
    }

    @Override
    public void savaComment(Comment comment) {
        commentDao.savaComment(comment);
    }

}
