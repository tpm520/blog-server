package com.tpblog.user.api.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date createtime;
}
