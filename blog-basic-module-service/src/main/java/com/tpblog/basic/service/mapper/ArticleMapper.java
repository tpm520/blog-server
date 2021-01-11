package com.tpblog.basic.service.mapper;

import com.tpblog.basic.api.entity.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    Article selectArticleById(Integer id);

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
