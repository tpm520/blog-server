package com.tpblog.basic.api.entity.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Review {
    private Integer id;
    // 父id
    private Integer pid;
    // 用户id
    private Integer uid;
    // 文章id
    private Integer aid;
    // 评论内容
    private String reviewContent;
    private Date createTime;
    private Date updateTime;
}
