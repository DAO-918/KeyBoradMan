package com.kp.domain;

import java.util.Date;
import lombok.Data;


public class UserInfo2 {
    /**
    * 注意 该id与user的id名称相同
    */
    private Integer user_id;

    private String user_name;

    private String user_email;

    /**
    * 用户性别
    */
    private String user_sex;

    /**
    * 电话
    */
    private Long user_phone;

    /**
    * 用户经验
    */
    private String user_ex;

    /**
    * 注册时间/更改时间
    */
    private Date user_time;

    /**
    * 用户签名
    */
    private String user_show;

    /**
    * 用户主页链接
    */
    private String user_blog;

    /**
    * 用户头像
    */
    private String user_img;

    /**
    * 用户粉丝数
    */
    private Integer user_fans;

    /**
    * 用户关注别人的数量
    */
    private Integer user_concern;

    /**
     * 用户发过的文章数量
     */
    private Integer articleCount;


    /**
     * User 用户
     */
    private User user;


    public UserInfo2() {
    }

    public UserInfo2(Integer user_id, String user_name, String user_email, String user_sex, Long user_phone, String user_ex, Date user_time, String user_show, String user_blog, String user_img, Integer user_fans, Integer user_concern, Integer articleCount, User user) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_sex = user_sex;
        this.user_phone = user_phone;
        this.user_ex = user_ex;
        this.user_time = user_time;
        this.user_show = user_show;
        this.user_blog = user_blog;
        this.user_img = user_img;
        this.user_fans = user_fans;
        this.user_concern = user_concern;
        this.articleCount = articleCount;
        this.user = user;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public Long getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(Long user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_ex() {
        return user_ex;
    }

    public void setUser_ex(String user_ex) {
        this.user_ex = user_ex;
    }

    public Date getUser_time() {
        return user_time;
    }

    public void setUser_time(Date user_time) {
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

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfo2{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_phone=" + user_phone +
                ", user_ex='" + user_ex + '\'' +
                ", user_time=" + user_time +
                ", user_show='" + user_show + '\'' +
                ", user_blog='" + user_blog + '\'' +
                ", user_img='" + user_img + '\'' +
                ", user_fans=" + user_fans +
                ", user_concern=" + user_concern +
                ", articleCount=" + articleCount +
                ", user=" + user +
                '}';
    }
}