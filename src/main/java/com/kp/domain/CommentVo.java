package com.kp.domain;

/**
 * 评论分页类
 */
public class CommentVo {
    private Integer pageNo;
    private Integer art_id;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getArt_id() {
        return art_id;
    }

    public void setArt_id(Integer art_id) {
        this.art_id = art_id;
    }
}
