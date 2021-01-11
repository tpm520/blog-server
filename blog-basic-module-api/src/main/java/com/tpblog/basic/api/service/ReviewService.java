package com.tpblog.basic.api.service;

public interface ReviewService {
    /**
     * 根据文章id获取评论数量
     * @param aid
     * @return
     */
    Integer reviewCount(Integer aid);
}
