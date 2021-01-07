package com.tpblog.main.api.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Result implements Serializable {
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
