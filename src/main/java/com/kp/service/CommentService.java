package com.kp.service;

import com.kp.domain.Comment;
import com.kp.domain.GreatComment;

public interface CommentService {
    //获取用户评论关系表信息
    Comment findGreatComment(GreatComment greatComment);

    //增加一条评论
    void savaComment(Comment comment);
}
