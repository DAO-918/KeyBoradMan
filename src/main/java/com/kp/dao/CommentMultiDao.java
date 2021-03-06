package com.kp.dao;

import com.kp.domain.BackCommentMulti;
import com.kp.domain.CommentMulti;

import java.util.List;

public interface CommentMultiDao {
    //删除多级评论
    public int deleteCommentMulti(List<String> list);
    //后台根据一级评论查找多级评论
    public List<BackCommentMulti> findBackCommentMulitiByCid(int comment_id);
    //查找所有多级评论
    public List<CommentMulti> findCommentMuliti();

}
