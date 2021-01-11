package com.tpblog.basic.service.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    String findUsernameByUid(Integer uid);
}
