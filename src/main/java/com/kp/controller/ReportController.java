package com.kp.controller;

import com.kp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value="/backInfo/", method= RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Map<String,Integer> getBackPageInfo(){
        Map<String, Integer> map = reportService.BackMainPageInfo();
        return map;
    }
}
