package com.kp.domain;

public class UserInfo {

    private Integer user_id;
    private String user_name;
    private String user_email;
    private String user_sex;
    private String user_phone;
    private String user_ex;
    private String user_time;
    private String user_show;
    private String user_blog;
    private String user_img;
    private Integer user_fans;
    private Integer user_concern;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_ex() {
        return user_ex;
    }

    public void setUser_ex(String user_ex) {
        this.user_ex = user_ex;
    }

    public String getUser_time() {
        return user_time;
    }

    public void setUser_time(String user_time) {
        this.user_time = user_time;
    }

    public String getUser_show() {
        return user_show;
    }

    public void setUser_show(String user_show) {
        this.user_show = user_show;
    }

    public String getUser_blog() {
        return user_blog;
    }

    public void setUser_blog(String user_blog) {
        this.user_blog = user_blog;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public Integer getUser_fans() {
        return user_fans;
    }

    public void setUser_fans(Integer user_fans) {
        this.user_fans = user_fans;
    }

    public Integer getUser_concern() {
        return user_concern;
    }

    public void setUser_concern(Integer user_concern) {
        this.user_concern = user_concern;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_phone=" + user_phone +
                ", user_ex='" + user_ex + '\'' +
                ", user_time='" + user_time + '\'' +
                ", user_show='" + user_show + '\'' +
                ", user_blog='" + user_blog + '\'' +
                ", user_img='" + user_img + '\'' +
                ", user_fans=" + user_fans +
                ", user_concern=" + user_concern +
                '}';
    }
}
