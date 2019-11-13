package com.kp.dao;

import com.kp.domain.Comment;
import com.kp.domain.GreatComment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao {

    //获取用户点赞评论关系表信息
    GreatComment findGreatComment(GreatComment greatComment);

    //保存用户点赞评论信息
    void saveGreatComment(GreatComment greatComment);

    //更新评论表点赞数加1
    void addComLike(Integer com_id);

    //更新评论表点赞数减1
    void decComLike(Integer com_id);

    //获取评论点赞信息
    Comment findCommentByComId(Integer com_id);

    //更新啊评论点赞表点赞标志
    void updateGreatComment(GreatComment greatComment);

    //增加一条评论
    void savaComment(Comment comment);

}
