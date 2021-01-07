package com.tpblog.main.controller.oam;

import com.tpblog.main.api.response.Result;
import com.tpblog.main.api.response.ResultUtil;
import com.tpblog.main.service.oam.BlackListMainService;
import com.tpblog.main.service.user.UserService;
import com.tpblog.main.utils.LoginCheck;
import com.tpblog.oam.api.entity.BlackList;
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
public class BlackListMainController {

    @Autowired
    private BlackListMainService blackListMainService;

    @Autowired
    private LoginCheck loginCheck;

    @Autowired
    private UserService userService;

    @GetMapping("find")
    public Result findBlackListAll(HttpServletRequest request){
        Result login = loginCheck.isLogin(request);
        if (login!=null) {
            return login;
        }
        List<BlackList> blackListAll = blackListMainService.findBlackListAll();
        return ResultUtil.success(blackListAll);
    }
}
