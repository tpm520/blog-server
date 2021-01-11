package com.tpblog.basic.service.impl;

import com.tpblog.basic.api.entity.pojo.Article;
import com.tpblog.basic.api.service.ArticleService;
import com.tpblog.basic.service.mapper.ArticleMapper;
import com.tpblog.basic.service.mapper.ReviewMapper;
import com.tpblog.basic.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    /**
     * 根据用户Id查询文章
     * @param id
     * @return
     */
    @Override
    public Article findArticleById(Integer id) {
        return articleMapper.selectArticleById(id);
    }

    /**
     * 查询所有文章
     * @return
     */
    @Override
    public List<Article> findArticleAll() {
        List<Article> articleAll = articleMapper.findArticleAll();
        transfer(articleAll);
        return articleAll;
    }

    /**
     * 分页查询
     * @param start
     * @param pageNum
     * @return
     */
    @Override
    public List<Article> findArticleByPage(Integer start, Integer pageNum) {
        List<Article> articleByPage = articleMapper.findArticleByPage(start, pageNum);
        transfer(articleByPage);
        return articleByPage;
    }
    // 添加必要返回
    private void transfer(List<Article> articles){
        articles.forEach(article -> {
            article.setCommentsCount(reviewMapper.reviewCount(article.getId()));
            article.setUsername(userMapper.findUsernameByUid(article.getUid()));
        });
    }

    /**
     * 查询文章总量
     * @return
     */
    @Override
    public Integer findArticleNums() {
        return articleMapper.findArticleNums();
    }
}
