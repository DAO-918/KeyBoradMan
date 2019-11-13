package com.kp.controller;

import com.kp.domain.ArticleTag;
import com.kp.domain.Category;
import com.kp.service.ArticleTagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleTagController {
    private ArticleTagService articleTagService;
    @RequestMapping(path = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<ArticleTag> listArticleTag(Category category,HttpServletRequest request, HttpServletResponse response){
        List<ArticleTag> articleTags = articleTagService.listArticleTag(category);
        try {
            request.getRequestDispatcher("/html/index.html").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articleTags;
    }

}
