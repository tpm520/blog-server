package com.tpblog.main.controller.basic;

import com.tpblog.basic.api.entity.Article;
import com.tpblog.main.service.basic.ArticleMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main")
public class ArticleMainController {

    @Autowired
    private ArticleMainService articleMainService;

    @GetMapping("article/find/{id}")
    public Article findArticleById(@PathVariable("id") Integer id){
        return articleMainService.findArticleById(id);
    }
}
