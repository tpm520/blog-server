package com.tpblog.user.api.enums;

public enum ResponseStatusCode {

    RegisterError(501,"注册失败"),
    LoginError(502,"登录失败"),
    NotFind(404,"请求数据未找到");

    private Integer code;
    private String message;
    private ResponseStatusCode(){}
    private ResponseStatusCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }
}
