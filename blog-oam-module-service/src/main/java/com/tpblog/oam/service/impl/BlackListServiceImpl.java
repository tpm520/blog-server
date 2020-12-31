package com.tpblog.oam.service.impl;

import com.tpblog.oam.api.entity.BlackList;
import com.tpblog.oam.api.service.BlackListService;
import com.tpblog.oam.service.mapper.BlackListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    private BlackListMapper blackListMapper;

    @Override
    public List<BlackList> findBlockListAll() {
        return blackListMapper.findBlackListAll();
    }
}
