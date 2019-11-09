package com.kp.domain;

import lombok.Data;

@Data
public class Category {
    /**
    * 类别
    */
    private Integer categoryId;

    /**
    * 类别名称
    */
    private String categoryName;

    /**
    * 类别说明
    */
    private String categoryContent;
}