package com.tpblog.basic.service.impl;

import com.tpblog.basic.api.entity.Article;
import com.tpblog.basic.api.service.ArticleService;
import com.tpblog.basic.service.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article findArticleById(Integer id) {
        return articleMapper.selectArticleById(id);
    }
}
