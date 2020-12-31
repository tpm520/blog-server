package com.tpblog.main.service.basic;

import com.tpblog.basic.api.entity.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "blog-basic-service",path = "article")
public interface ArticleMainService {
    @GetMapping("find/{id}")
    Article findArticleById(@PathVariable("id") Integer id);
}
