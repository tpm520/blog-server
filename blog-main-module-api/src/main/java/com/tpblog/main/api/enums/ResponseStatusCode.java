package com.tpblog.main.api.enums;

public enum ResponseStatusCode {

    SUCCESS(200,"请求成功"),
    FAILED(500,"请求失败"),
    NOT_FIND(404,"请求数据未找到"),
    NOT_LOGIN(301,"未登录");

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
