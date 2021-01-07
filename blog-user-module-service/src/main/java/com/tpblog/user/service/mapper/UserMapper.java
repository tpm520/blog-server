package com.tpblog.user.service.mapper;

import com.tpblog.user.api.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findUserAll();

    Integer registerUser(User user);

    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username,String password);
}
