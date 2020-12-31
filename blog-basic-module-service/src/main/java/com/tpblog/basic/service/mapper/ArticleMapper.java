package com.tpblog.basic.service.mapper;

import com.tpblog.basic.api.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    Article selectArticleById(Integer id);
}
