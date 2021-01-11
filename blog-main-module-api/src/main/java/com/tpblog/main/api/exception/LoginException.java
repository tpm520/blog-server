package com.tpblog.main.api.exception;

public class LoginException extends CommonException{
    public LoginException(){}
    public LoginException(String s,int code) {
        super(s,code);
    }
}
