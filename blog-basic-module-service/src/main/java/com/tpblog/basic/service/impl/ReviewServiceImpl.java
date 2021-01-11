package com.tpblog.basic.service.impl;

import com.tpblog.basic.api.service.ReviewService;
import com.tpblog.basic.service.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;
    @Override
    public Integer reviewCount(Integer aid) {
        return reviewMapper.reviewCount(aid);
    }
}
