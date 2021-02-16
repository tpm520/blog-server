package com.tpblog.user.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.tpblog.user.api.entity.User;
import com.tpblog.user.api.exception.ExceptionUtil;
import com.tpblog.user.api.service.UserService;
import com.tpblog.user.service.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public List<User> findUserAll() {
        return userMapper.findUserAll();
    }

    @Override
    public Integer registerUser(User user) {
        String username = user.getUsername();
        User userByUsername = userMapper.findUserByUsername(username);
        if (userByUsername != null) {
            throw new ExceptionUtil.RegisterFailed("用户名【"+username+"】已存在");
        }
        return userMapper.registerUser(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        password = SecureUtil.md5(password);
        User user = userMapper.findUserByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public Boolean logout(String username) {
        String userMd5 = SecureUtil.md5(username);
        redisTemplate.delete(userMd5);
        if(redisTemplate.hasKey(userMd5)){
            log.info("redis缓存用户未清除");
            return false;
        }else {
            log.info("退出登录");
        }
        return true;
    }
}
