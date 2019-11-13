package com.kp.domain;

public class GreatArticle {
    private Integer ga_id;
    private Integer ga_art_id;
    private Integer ga_user_id;
    private Integer ga_status;

    @Override
    public String toString() {
        return "GreatArticle{" +
                "ga_id=" + ga_id +
                ", ga_art_id=" + ga_art_id +
                ", ga_user_id=" + ga_user_id +
                ", ga_status=" + ga_status +
                '}';
    }

    public Integer getGa_id() {
        return ga_id;
    }

    public void setGa_id(Integer ga_id) {
        this.ga_id = ga_id;
    }

    public Integer getGa_art_id() {
        return ga_art_id;
    }

    public void setGa_art_id(Integer ga_art_id) {
        this.ga_art_id = ga_art_id;
    }

    public Integer getGa_user_id() {
        return ga_user_id;
    }

    public void setGa_user_id(Integer ga_user_id) {
        this.ga_user_id = ga_user_id;
    }

    public Integer getGa_status() {
        return ga_status;
    }

    public void setGa_status(Integer ga_status) {
        this.ga_status = ga_status;
    }
}
