package com.kp.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Report {
    private Integer reportId;

    /**
    * 举报文章的id
    */
    private Integer reportArtId;

    private String reportContent;

    /**
    * 提交时间
    */
    private Date reportDate;
}