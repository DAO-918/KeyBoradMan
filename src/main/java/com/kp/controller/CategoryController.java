package com.kp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.ArticleTag;
import com.kp.domain.Category;
import com.kp.domain.Msg;
import com.kp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //创建线程安全的Map
    //static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value="/", method= RequestMethod.PUT)
    public Msg insertCategory(Category category){
        boolean flag = categoryService.insertCategory(category);
        return Msg.sucess().add("msgInfo","添加类型操作成功").add("flag",flag);
    }

    @RequestMapping(value="/", method= RequestMethod.DELETE)
    public Msg deleteTag(String delIds){
        String[] Ids = delIds.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(Ids));
        boolean flag = categoryService.deleteCategory(list);
        return Msg.sucess().add("msgInfo","删除类型操作成功").add("flag",flag);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.POST)
    public Msg updateTag(@PathVariable Integer id, Category category){
        System.out.println("---------"+id+"---------");
        boolean flag = categoryService.updateCategory(category);
        return Msg.sucess().add("msgInfo","更新类型操作成功").add("flag",flag);
    }

    @RequestMapping(value="/bc/", method= RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String findBackCategory(int pageNumber, int pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        List<Category> tagList = categoryService.findBackCategory();
        PageInfo pageInfo = new PageInfo(tagList);
        JSONObject result = new JSONObject();
        result.put("total", pageInfo.getTotal());
        result.put("rows", pageInfo.getList());
        return result.toJSONString();
    }

    @RequestMapping(value="/", method= RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public List<Category> findCategory(){
        List<Category> categoryList = categoryService.findCategory();
        return categoryList;
    }

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
