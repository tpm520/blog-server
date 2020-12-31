package com.tpblog.oam.service.controller;

import com.tpblog.oam.api.entity.BlackList;
import com.tpblog.oam.api.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("blacklist")
public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    @GetMapping("find")
    public List<BlackList> findBlackListAll(){
        return blackListService.findBlockListAll();
    }
}
