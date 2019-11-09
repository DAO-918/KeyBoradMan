package com.kp.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Comment {
    /**
    * 一级评论id
    */
    private Integer comId;

    /**
    * 评论正文
    */
    private String comContent;

    /**
    * 文章id
    */
    private Integer comArtId;

    /**
    * 评论用户的id
    */
    private Integer comUserId;

    /**
    * 点赞数
    */
    private Integer comLike;

    /**
    * 评论时间
    */
    private Date comTime;
}