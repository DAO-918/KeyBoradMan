package com.kp.service;

import com.kp.domain.BackCommentMulti;
import com.kp.domain.CommentMulti;

import java.util.List;

public interface CommentMultiService {
    //删除多级评论
    public boolean deleteCommentMulti(List<String> list);
    //根据一级评论查找多级评论
    public List<BackCommentMulti> findBackCommentMulitiByCid(int comment_id);
    //查找所有多级评论
    public List<CommentMulti> findCommentMuliti();
}
