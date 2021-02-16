package com.tpblog.user.service.controller;

import cn.hutool.crypto.SecureUtil;
import com.tpblog.user.api.entity.User;
import com.tpblog.user.api.exception.ExceptionUtil;
import com.tpblog.user.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @GetMapping("find/all")
    public List<User> findUserAll(){
        return userService.findUserAll();
    }

    /**
     * 注册用户
     * @param username
     * @param password
     * @return
     */
    @PostMapping("register")
    public Integer registerUser(@RequestParam("username") String username,
                             @RequestParam("password") String password){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new ExceptionUtil.RegisterFailed("用户名或密码不能为空");
        }
        User user = new User();
        user.setUsername(username);
        password = SecureUtil.md5(password);
        user.setPassword(password);
        user.setCreatetime(new Date());
        return userService.registerUser(user);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public Boolean login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         HttpServletResponse response){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new ExceptionUtil.LoginFailed("用户名或密码不能为空");
        }
        // 是否登录
        if (isLogin(SecureUtil.md5(username))) {
            return true;
        }
        User user = userService.findUserByUsernameAndPassword(username, password);
        if (user == null) {
            return false;
        }
        Cookie cookie = new Cookie("blog_user", SecureUtil.md5(username));
        cookie.setMaxAge(30*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(SecureUtil.md5(username),user,30, TimeUnit.MINUTES);
        return true;
    }

    /**
     * 退出登录
     * @param username
     * @return
     */
    @GetMapping("logout")
    public Boolean logout(@RequestParam("username") String username){
        return userService.logout(username);
    }

    /**
     * 是否登录
     * @param username
     * @return
     */
    @GetMapping("isLogin")
    public Boolean login(@RequestParam("username") String username){
        return isLogin(username);
    }

    private Boolean isLogin(String username) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        User cache = (User)valueOperations.get(username);
        if (cache!=null) {
            log.info("击中【"+username+"】缓存");
            return true;
        }
        log.info("未登录");
        return false;
    }

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    @GetMapping("find/{username}")
    public User findUserByUsername(@PathVariable("username") String username){
        User userByUsername = userService.findUserByUsername(username);
        return userByUsername;
    }
}
