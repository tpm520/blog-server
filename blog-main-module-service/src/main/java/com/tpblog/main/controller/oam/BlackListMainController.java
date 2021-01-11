package com.tpblog.main.controller.oam;

import com.tpblog.main.api.annotation.RequireLogin;
import com.tpblog.main.api.response.Result;
import com.tpblog.main.api.response.ResultUtil;
import com.tpblog.main.service.oam.BlackListMainService;
import com.tpblog.main.service.user.UserService;
import com.tpblog.main.utils.LoginCheck;
import com.tpblog.oam.api.entity.BlackList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("blacklist")
@Slf4j
@Api(tags = "BlackListMainController",description = "黑名单相关接口")
public class BlackListMainController {

    @Autowired
    private BlackListMainService blackListMainService;

    @Autowired
    private LoginCheck loginCheck;

    @GetMapping("find")
    @ApiOperation(value = "查询所有黑名单")
    @RequireLogin
    public Result findBlackListAll(HttpServletRequest request){
        List<BlackList> blackListAll = blackListMainService.findBlackListAll();
        return ResultUtil.success(blackListAll);
    }
}
