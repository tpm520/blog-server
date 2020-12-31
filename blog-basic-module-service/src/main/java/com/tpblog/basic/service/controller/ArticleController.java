package com.tpblog.basic.service.controller;

import com.tpblog.basic.api.entity.Article;
import com.tpblog.basic.api.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("find/{id}")
    public Article findArticleById(@PathVariable("id") Integer id){
        return articleService.findArticleById(id);
    }
}
