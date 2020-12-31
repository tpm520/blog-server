package com.tpblog.basic.api.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Article {
    private Integer id;
    private Integer uid;
    private Integer reviewId;
    private Integer viewNum;
    private String content;
    private Date createTime;
    private Date updateTime;
}
