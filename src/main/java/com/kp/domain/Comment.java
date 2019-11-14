package com.kp.domain;

import java.util.Date;
import lombok.Data;

public class Comment {
    private Integer com_id;
    private String com_content;
    private Integer com_art_id;
    private Integer com_user_id;
    private Integer com_like;
    private Date com_time;

    @Override
    public String toString() {
        return "Comment{" +
                "com_id=" + com_id +
                ", com_content='" + com_content + '\'' +
                ", com_art_id=" + com_art_id +
                ", com_user_id=" + com_user_id +
                ", com_like=" + com_like +
                ", com_time=" + com_time +
                '}';
    }

    public Integer getCom_id() {
        return com_id;
    }

    public void setCom_id(Integer com_id) {
        this.com_id = com_id;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public Integer getCom_art_id() {
        return com_art_id;
    }

    public void setCom_art_id(Integer com_art_id) {
        this.com_art_id = com_art_id;
    }

    public Integer getCom_user_id() {
        return com_user_id;
    }

    public void setCom_user_id(Integer com_user_id) {
        this.com_user_id = com_user_id;
    }

    public Integer getCom_like() {
        return com_like;
    }

    public void setCom_like(Integer com_like) {
        this.com_like = com_like;
    }

    public Date getCom_time() {
        return com_time;
    }

    public void setCom_time(Date com_time) {
        this.com_time = com_time;
    }
}
