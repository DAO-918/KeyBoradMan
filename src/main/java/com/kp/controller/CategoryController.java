package com.kp.controller;


import com.kp.domain.ArticleTag;
import com.kp.domain.Category;
import com.kp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/*@Controller
@RequestMapping("/category")*/
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

//    @RequestMapping(path = "/list",method = RequestMethod.GET)
//    @ResponseBody
    //查询每个分类的标签
    @GetMapping("/list")
    public List<ArticleTag> listCategory(String category_name){
        Category category = new Category();
        category.setCategory_name(category_name);
        List<ArticleTag> articleTags = categoryService.searchCategory(category);
        return articleTags;
    }

    //查询分类的
    @GetMapping("/search")
    public List<Category> searchName(){
        List<Category> search = categoryService.search();
        return search;
    }
}
