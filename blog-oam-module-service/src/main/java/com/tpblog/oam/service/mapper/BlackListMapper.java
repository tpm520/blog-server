package com.tpblog.oam.service.mapper;

import com.tpblog.oam.api.entity.BlackList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlackListMapper {
    List<BlackList> findBlackListAll();
}
