package com.tpblog.basic.api.service;

import com.tpblog.basic.api.entity.Article;

public interface ArticleService {
    Article findArticleById(Integer id);
}
