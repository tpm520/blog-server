package com.tpblog.basic.api.entity.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Article {
    private Integer id;
    private Integer uid;
    private String username;
    // 文章标题
    private String title;
    // 文章简介
    private String summary;
    // 文章类型
    private String type;
    // 是否置顶 0 false,1 true
    private short isTop;
    // 是否热门 0 false,1 true
    private short isHot;
    // 文章热度
    private Integer viewsCount;
    // 评论数量
    private Integer commentsCount;
    // 文章内容
    private String content;
    private Date createTime;
    private Date updateTime;
}
