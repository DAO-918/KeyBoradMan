package com.kp.domain;

public class GreatComment {
    private Integer gc_id;
    private Integer gc_com_id;
    private Integer gc_user_id;
    private Integer gc_status;

    @Override
    public String toString() {
        return "GreatComment{" +
                "gc_id=" + gc_id +
                ", gc_com_id=" + gc_com_id +
                ", gc_user_id=" + gc_user_id +
                ", gc_status=" + gc_status +
                '}';
    }

    public Integer getGc_id() {
        return gc_id;
    }

    public void setGc_id(Integer gc_id) {
        this.gc_id = gc_id;
    }

    public Integer getGc_com_id() {
        return gc_com_id;
    }

    public void setGc_com_id(Integer gc_com_id) {
        this.gc_com_id = gc_com_id;
    }

    public Integer getGc_user_id() {
        return gc_user_id;
    }

    public void setGc_user_id(Integer gc_user_id) {
        this.gc_user_id = gc_user_id;
    }

    public Integer getGc_status() {
        return gc_status;
    }

    public void setGc_status(Integer gc_status) {
        this.gc_status = gc_status;
    }
}
