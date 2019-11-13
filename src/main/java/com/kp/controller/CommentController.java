package com.kp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.BackComment;
import com.kp.domain.Msg;
import com.kp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/", method= RequestMethod.DELETE)
    public Msg deleteComment(String delIds){
        String[] Ids = delIds.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(Ids));
        boolean flag = commentService.deleteComment(list);
        return Msg.sucess().add("msgInfo","删除一级评论操作成功").add("flag",flag);
    }

    @RequestMapping(value="/bc/", method= RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String findCategory(int pageNumber, int pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        List<BackComment> commentList = commentService.findBackComment();
        PageInfo pageInfo = new PageInfo(commentList);
        JSONObject result = new JSONObject();
        result.put("total", pageInfo.getTotal());
        result.put("rows", pageInfo.getList());
        return result.toJSONString();
    }
}
