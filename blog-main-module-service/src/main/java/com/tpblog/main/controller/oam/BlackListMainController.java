package com.tpblog.main.controller.oam;

import com.tpblog.main.service.oam.BlackListMainService;
import com.tpblog.oam.api.entity.BlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("blacklist")
public class BlackListMainController {

    @Autowired
    private BlackListMainService blackListMainService;

    @GetMapping("find")
    public List<BlackList> findBlackListAll(){
        List<BlackList> blackListAll = blackListMainService.findBlackListAll();

        return blackListAll;
    }
}
