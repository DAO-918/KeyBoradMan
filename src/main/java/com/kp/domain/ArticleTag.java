package com.kp.domain;

import lombok.Data;


public class ArticleTag {
    private Integer tag_id;
    private Integer tag_cid;//标签类别
    private String tag_name;
    private String tag_content;//标签介绍

    @Override
    public String toString() {
        return "ArticleTag{" +
                "tag_id=" + tag_id +
                ", tag_cid=" + tag_cid +
                ", tag_name='" + tag_name + '\'' +
                ", tag_content='" + tag_content + '\'' +
                '}';
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public Integer getTag_cid() {
        return tag_cid;
    }

    public void setTag_cid(Integer tag_cid) {
        this.tag_cid = tag_cid;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getTag_content() {
        return tag_content;
    }

    public void setTag_content(String tag_content) {
        this.tag_content = tag_content;
    }
}