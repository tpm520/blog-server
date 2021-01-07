package com.tpblog.main.utils;

import com.tpblog.main.api.response.Result;
import com.tpblog.main.api.response.ResultUtil;
import com.tpblog.main.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class LoginCheck {

    @Autowired
    private UserService userService;


    /**
     * 验证是否登录
     * @param request
     * @return
     */
    public Result isLogin(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String username = null;
        for (Cookie cookie:cookies) {
            if ("blog_user".equals(cookie.getName())) {
                username = cookie.getValue();
                Boolean login = userService.login(cookie.getValue());
                if (!login){
                    log.info("--此操作需要先登录--");
                    return ResultUtil.notLogin();
                }
                break;
            }
        }
        if (username == null) {
            log.info("--此操作需要先登录--");
            return ResultUtil.notLogin();
        }
        return null;
    }
}
