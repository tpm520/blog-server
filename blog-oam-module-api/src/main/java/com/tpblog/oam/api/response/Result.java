package com.tpblog.oam.api.response;

public class Result {
    private String message;
    private Integer code;
    private Object data;

    public Result(Integer code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
