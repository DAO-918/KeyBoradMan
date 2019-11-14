package com.kp.domain;

import java.util.Date;
import lombok.Data;

public class Report {

    private Integer report_id;
    private Integer report_art_id;
    private String report_content;
    private Date report_date;

    @Override
    public String toString() {
        return "Report{" +
                "report_id=" + report_id +
                ", report_art_id=" + report_art_id +
                ", report_content='" + report_content + '\'' +
                ", report_date=" + report_date +
                '}';
    }

    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    public Integer getReport_art_id() {
        return report_art_id;
    }

    public void setReport_art_id(Integer report_art_id) {
        this.report_art_id = report_art_id;
    }

    public String getReport_content() {
        return report_content;
    }

    public void setReport_content(String report_content) {
        this.report_content = report_content;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }
}