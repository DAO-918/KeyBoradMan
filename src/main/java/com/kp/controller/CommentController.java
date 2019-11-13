package com.kp.controller;

import com.kp.domain.Comment;
import com.kp.domain.GreatComment;
import com.kp.domain.Msg;
import com.kp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/greatComment")
    public  Comment greatComment(Integer com_id,Integer user_id){
        GreatComment greatComment = new GreatComment();
        greatComment.setGc_com_id(com_id);
        greatComment.setGc_user_id(user_id);
        Comment comment = commentService.findGreatComment(greatComment);
        return comment;
    }

    @PostMapping("/comment")
    public Msg addComent(@RequestBody Comment comment){
        commentService.savaComment(comment);
        return Msg.sucess();
    }
}
