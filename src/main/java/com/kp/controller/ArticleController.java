package com.kp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.*;
import com.kp.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public Msg getListArticle(Integer pageNo) throws ParseException {
        //这是一个分页查询
        //引入PageHelp分页插件
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNo,4);//自动添加limit 0,8
        //startPage后面紧跟的查询就是分页查询
        List<Article> allArticle = articleService.findAllArticle();
        //date类毫秒值转时间字符串
        Msg msg = new Msg();
        for (Article article : allArticle) {
            Date art_create_time = article.getArt_create_time();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(art_create_time);
            msg.setTime(format);
        }
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        //封装了详细的分页信息,传入连续显示的页数
        PageInfo pageInfo=new PageInfo(allArticle,4);
        Msg pageInfo1 = msg.sucess().add("pageInfo", pageInfo);
        pageInfo1.setTime(msg.getTime());
        return pageInfo1;
    }

    @GetMapping("/articleById")
    public Article findById(Integer art_id){
        Article articleById = articleService.findArticleById(art_id);
        return articleById;
    }

    @GetMapping("/articleByTarName")
    public Msg listArticeBytagName(Integer pageNo,@Param("tag_name")String tag_name,@Param("keyboard")String keyboard) throws ParseException {
        //这是一个分页查询
        //引入PageHelp分页插件
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNo,4);//自动添加limit 0,8
        //startPage后面紧跟的查询就是分页查询
        List<Article> articleByTagName = articleService.findArticleByTagName(tag_name,keyboard);
        //date类毫秒值转时间字符串
        Msg msg = new Msg();
        for (Article article : articleByTagName) {
            Date art_create_time = article.getArt_create_time();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(art_create_time);
            msg.setTime(format);
        }
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        //封装了详细的分页信息,传入连续显示的页数
        PageInfo pageInfo=new PageInfo(articleByTagName,4);
        Msg pageInfo1 = msg.sucess().add("pageInfo", pageInfo);
        pageInfo1.setTime(msg.getTime());
        return pageInfo1;
    }

    @GetMapping("/comment")
    public Msg listComment(Integer pageNo,Integer art_id){
        //这是一个分页查询
        //引入PageHelp分页插件
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNo,1);//自动添加limit 0,8
        //startPage后面紧跟的查询就是分页查询
        List<Comment> commentList = articleService.listComment(art_id);
        //date类毫秒值转时间字符串
        Msg msg = new Msg();
        for (Comment comment : commentList) {
            Date com_time = comment.getCom_time();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(com_time);
            msg.setTime(format);
        }
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        //封装了详细的分页信息,传入连续显示的页数
        PageInfo pageInfo=new PageInfo(commentList,3);
        Msg pageInfo1 = msg.sucess().add("pageInfo", pageInfo);
        pageInfo1.setTime(msg.getTime());
        return pageInfo1;
    }

    @GetMapping("greatArticle")
    public  Article greatArticle(Integer art_id,Integer user_id){
        GreatArticle greatArticle = new GreatArticle();
        greatArticle.setGa_art_id(art_id);
        greatArticle.setGa_user_id(user_id);
        Article article = articleService.findGreatArticle(greatArticle);
        return article;
    }

    @GetMapping("great")
    public GreatArticle findGAStatus(Integer art_id,Integer user_id){
        GreatArticle greatArticle = new GreatArticle();
        greatArticle.setGa_art_id(art_id);
        greatArticle.setGa_user_id(user_id);
        return articleService.findGAStatus(greatArticle );
    }

    @PutMapping("/addArticle")
    public void addArticle(HttpServletRequest req, HttpServletResponse resp,MultipartFile art_img, Integer art_user_id, String art_title, Integer art_tag_id, Integer art_category_id, String art_content) throws IOException {
        Article article = new Article();
        article.setArt_user_id(art_user_id);
        article.setArt_title(art_title);
        article.setArt_tag_id(art_tag_id);
        article.setArt_category_id(art_category_id);
        article.setArt_content(art_content);

        //上传的位置
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFiles/");
        //判断该路径是否存在
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        //获取上传文件的名称
        String fileName = art_img.getOriginalFilename();
        //把文件名设置成唯一值。UUID
        String uuid = UUID.randomUUID().toString().replace("_", "");
        fileName = uuid + "_" +fileName;
        //上传文件
        art_img.transferTo(new File(realPath,fileName));

        String file_src = "uploadFiles/"+fileName;
        article.setArt_img(file_src);

        articleService.saveArticle(article);

        resp.sendRedirect("/article/blog.html");
    }

    @GetMapping("/listArt")
    public List<Article> listArticle(){
        List<Article> articles = articleService.listArtTitle();
        return articles;
    }

    @GetMapping("/searchArt")
    public List<Article> searchArticle(){
        List<Article> articles = articleService.searchArtTitle();
        return articles;
    }
}
