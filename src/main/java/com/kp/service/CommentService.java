package com.kp.service;

import com.kp.domain.BackComment;

import java.util.List;

public interface CommentService {
    //删除一级评论
    public boolean deleteComment(List<String> list);
    //后台查找所有一级评论
    public List<BackComment> findBackComment();
}
