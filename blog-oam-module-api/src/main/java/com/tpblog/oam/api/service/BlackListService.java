package com.tpblog.oam.api.service;

import com.tpblog.oam.api.entity.BlackList;

import java.util.List;

public interface BlackListService {
    List<BlackList> findBlockListAll();
}
