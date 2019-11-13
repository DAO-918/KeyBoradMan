package com.kp.domain;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer category_id;
    private String category_name;
    private String category_content;

    public Category(Integer category_id, String category_name, String category_content) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_content = category_content;
    }

    public Category() {
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_content() {
        return category_content;
    }

    public void setCategory_content(String category_content) {
        this.category_content = category_content;
    }

    @Override
    public String toString() {
        return "CategoryService{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", category_content='" + category_content + '\'' +
                '}';
    }
}
