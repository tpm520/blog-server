package com.tpblog.oam.api.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 访问黑名单
 */
@Data
@ToString
public class BlackList {
    private Integer id;
    private String ip;
    // 限制说明
    private String comment;
    private Date createtime;
}
