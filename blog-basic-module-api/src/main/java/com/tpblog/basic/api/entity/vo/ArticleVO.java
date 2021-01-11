package com.tpblog.basic.api.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ArticleVO {
    private Integer id;
    private String username;
    // 文章标题
    private String title;
    // 文章简介
    private String summary;
    // 文章类型
    private String type;
    // 是否置顶
    private Boolean isTop;
    // 是否热门
    private Boolean isHot;
    // 文章内容
    private String content;
    // 文章热度
    private Integer viewsCount;
    // 评论数量
    private Integer commentsCount;
    private Date createTime;
    private Date updateTime;
}
