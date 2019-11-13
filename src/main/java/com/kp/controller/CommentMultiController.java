package com.kp.controller;

import com.kp.domain.BackCommentMulti;
import com.kp.domain.CommentMulti;
import com.kp.domain.Msg;
import com.kp.service.CommentMultiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/multi")
public class CommentMultiController {
    @Autowired
    private CommentMultiService commentMultiService;

    @RequestMapping(value="/", method= RequestMethod.DELETE)
    public Msg deleteCommentMulti(String delIds){
        String[] Ids = delIds.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(Ids));
        boolean flag = commentMultiService.deleteCommentMulti(list);
        return Msg.sucess().add("msgInfo","删除多级评论操作成功").add("flag",flag);
    }

    @RequestMapping(value="/bcid/{id}", method= RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public List<BackCommentMulti> findCommentMultiById(@PathVariable Integer id){
        List<BackCommentMulti> commentMultiList = commentMultiService.findBackCommentMulitiByCid(id);
        return commentMultiList;
    }

    @RequestMapping(value="/bc/", method= RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public List<CommentMulti> findCommentMulti(){
        List<CommentMulti> commentMultiList = commentMultiService.findCommentMuliti();
        return commentMultiList;
    }
}
