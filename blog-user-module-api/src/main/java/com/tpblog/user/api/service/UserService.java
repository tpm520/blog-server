package com.tpblog.user.api.service;

import com.tpblog.user.api.entity.User;

import java.util.List;

public interface UserService {
    List<User> findUserAll();

    /**
     * 注册用户
     * @param user
     * @return
     */
    Integer registerUser(User user);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username,String password);

    /**
     * 退出登录
     * @param username
     * @return
     */
    Boolean logout(String username);
}
