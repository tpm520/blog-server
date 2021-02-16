package com.tpblog.main.controller.user;

import cn.hutool.crypto.SecureUtil;
import com.tpblog.main.api.model.dto.UserDTO;
import com.tpblog.main.api.response.Result;
import com.tpblog.main.api.response.ResultUtil;
import com.tpblog.main.service.user.UserService;
import com.tpblog.main.utils.StringUtil;
import com.tpblog.user.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param username
     * @param password
     * @return
     */
    @PostMapping("register")
    public Result register(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        Integer integer = userService.registerUser(username, password);
        String info = "注册失败";
        if (integer > 0){
            info = "注册成功";
        }
        return ResultUtil.success(info);
    }

    /**
     * 登录用户
     *
     * @return
     */
    @PostMapping("login")
    public Result login(@RequestBody UserDTO userDTO,
                        HttpServletRequest request,
                        HttpServletResponse response){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        String cookies = request.getHeader("Cookies");
        Map<String, String> blog_user = StringUtil.getCookie("blog_user", cookies);
        System.out.println(blog_user);
        Boolean login = userService.login(username, password);
        if (login) {
            Cookie cookie = new Cookie("blog_user", SecureUtil.md5(username));
            cookie.setMaxAge(30*60);
            cookie.setPath("/");
            response.addCookie(cookie);
            HashMap<String,Object> data = new HashMap<>();
            data.put("cookie",cookie);
            User userByUsername = userService.findUserByUsername(username);
            userByUsername.setPassword(null);
            data.put("user",userByUsername);
            return ResultUtil.success(data);
        }
        return ResultUtil.success("failed");
    }

    /**
     * 退出登录
     * @param username
     * @return
     */
    @GetMapping("logout/{username}")
    public Result logout(@PathVariable("username") String username){
        return ResultUtil.success(userService.logout(username));
    }

    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
    @GetMapping("/find/{username}")
    public Result findUserByUsername(@PathVariable("username") String username){
        User user = userService.findUserByUsername(username);
        if (user != null) {
            return ResultUtil.success("true");
        }
        return ResultUtil.success("false");
    }
}
