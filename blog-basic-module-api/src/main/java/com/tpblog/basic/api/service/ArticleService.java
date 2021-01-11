package com.tpblog.basic.api.service;

import com.tpblog.basic.api.entity.pojo.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 通过id查询文章
     * @param id
     * @return
     */
    Article findArticleById(Integer id);

    /**
     * 查询所有文章
     * @return
     */
    List<Article> findArticleAll();

    /**
     * 分页查询
     * @param start
     * @param pageNum
     * @return
     */
    List<Article> findArticleByPage(Integer start,Integer pageNum);

    /**
     * 查询文章总量
     * @return
     */
    Integer findArticleNums();
}
