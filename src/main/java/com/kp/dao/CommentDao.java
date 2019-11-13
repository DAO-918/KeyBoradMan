package com.kp.dao;

import com.kp.domain.BackComment;

import java.util.List;

public interface CommentDao {
    //删除一级评论
    public int deleteComment(List<String> list);
    //后台查找所有一级评论
    public List<BackComment> findBackComment();
}
