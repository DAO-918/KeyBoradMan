package com.kp.domain;

import java.util.Date;

public class UserCollection {
    private Integer col_id;
    private Integer col_art_id;
    private Integer col_user_id;
    private Date col_creat_time;

    @Override
    public String toString() {
        return "UserCollection{" +
                "col_id=" + col_id +
                ", col_art_id=" + col_art_id +
                ", col_user_id=" + col_user_id +
                ", col_creat_time=" + col_creat_time +
                '}';
    }

    public Integer getCol_id() {
        return col_id;
    }

    public void setCol_id(Integer col_id) {
        this.col_id = col_id;
    }

    public Integer getCol_art_id() {
        return col_art_id;
    }

    public void setCol_art_id(Integer col_art_id) {
        this.col_art_id = col_art_id;
    }

    public Integer getCol_user_id() {
        return col_user_id;
    }

    public void setCol_user_id(Integer col_user_id) {
        this.col_user_id = col_user_id;
    }

    public Date getCol_creat_time() {
        return col_creat_time;
    }

    public void setCol_creat_time(Date col_creat_time) {
        this.col_creat_time = col_creat_time;
    }
}
