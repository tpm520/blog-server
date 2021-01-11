package com.tpblog.basic.service.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    Integer reviewCount(Integer aid);
}
