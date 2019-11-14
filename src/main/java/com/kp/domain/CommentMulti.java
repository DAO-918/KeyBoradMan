package com.kp.domain;

import java.util.Date;
import lombok.Data;

public class CommentMulti {
    private Integer com_multi_id;
    private Integer com_id;
    private String com_multi_content;
    private Integer com_multi_user_id;
    private Integer com_multi_like;
    private Date com_multi_time;

    @Override
    public String toString() {
        return "CommentMulti{" +
                "com_multi_id=" + com_multi_id +
                ", com_id=" + com_id +
                ", com_multi_content='" + com_multi_content + '\'' +
                ", com_multi_user_id=" + com_multi_user_id +
                ", com_multi_like=" + com_multi_like +
                ", com_multi_time=" + com_multi_time +
                '}';
    }

    public Integer getCom_multi_id() {
        return com_multi_id;
    }

    public void setCom_multi_id(Integer com_multi_id) {
        this.com_multi_id = com_multi_id;
    }

    public Integer getCom_id() {
        return com_id;
    }

    public void setCom_id(Integer com_id) {
        this.com_id = com_id;
    }

    public String getCom_multi_content() {
        return com_multi_content;
    }

    public void setCom_multi_content(String com_multi_content) {
        this.com_multi_content = com_multi_content;
    }

    public Integer getCom_multi_user_id() {
        return com_multi_user_id;
    }

    public void setCom_multi_user_id(Integer com_multi_user_id) {
        this.com_multi_user_id = com_multi_user_id;
    }

    public Integer getCom_multi_like() {
        return com_multi_like;
    }

    public void setCom_multi_like(Integer com_multi_like) {
        this.com_multi_like = com_multi_like;
    }

    public Date getCom_multi_time() {
        return com_multi_time;
    }

    public void setCom_multi_time(Date com_multi_time) {
        this.com_multi_time = com_multi_time;
    }
}
