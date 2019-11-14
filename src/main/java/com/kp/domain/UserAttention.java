package com.kp.domain;

import lombok.Data;

import java.util.Date;

public class UserAttention {
    private Integer att_id;
    private Integer att_author_id;
    private Integer att_user_id;
    private Date att_creat_date;

    @Override
    public String toString() {
        return "UserAttention{" +
                "att_id=" + att_id +
                ", att_author_id=" + att_author_id +
                ", att_user_id=" + att_user_id +
                ", att_creat_date=" + att_creat_date +
                '}';
    }

    public Integer getAtt_id() {
        return att_id;
    }

    public void setAtt_id(Integer att_id) {
        this.att_id = att_id;
    }

    public Integer getAtt_author_id() {
        return att_author_id;
    }

    public void setAtt_author_id(Integer att_author_id) {
        this.att_author_id = att_author_id;
    }

    public Integer getAtt_user_id() {
        return att_user_id;
    }

    public void setAtt_user_id(Integer att_user_id) {
        this.att_user_id = att_user_id;
    }

    public Date getAtt_creat_date() {
        return att_creat_date;
    }

    public void setAtt_creat_date(Date att_creat_date) {
        this.att_creat_date = att_creat_date;
    }
}
