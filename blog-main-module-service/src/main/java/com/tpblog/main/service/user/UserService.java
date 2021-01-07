package com.tpblog.main.service.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "blog-user-service")
public interface UserService {
    /**
     * 注册用户
     * @param username
     * @param password
     * @return
     */
    @PostMapping("register")
    Integer registerUser(@RequestParam("username") String username,
                                @RequestParam("password") String password);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    Boolean login(@RequestParam("username") String username,
                         @RequestParam("password") String password);

    /**
     * 是否登录
     * @param username
     * @return
     */
    @GetMapping("isLogin")
    Boolean login(@RequestParam("username") String username);
}
