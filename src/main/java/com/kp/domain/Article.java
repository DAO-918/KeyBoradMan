package com.kp.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Article {
    private Integer artId;

    /**
    * 文章作者
    */
    private Integer artUserId;

    /**
    * 标题
    */
    private String artTitle;

    /**
    * 标签id
    */
    private Integer artTagId;

    /**
    * 类别id
    */
    private Integer artCategoryId;

    /**
    * 正文
    */
    private String artContent;

    /**
    * 创建时间
    */
    private Date artCreateTime;

    /**
    * 评论数
    */
    private Integer artComNum;

    /**
    * 浏览量
    */
    private Integer artHotNum;

    /**
    * 点赞数
    */
    private Integer artLikeNum;
}