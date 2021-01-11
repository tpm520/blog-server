package com.tpblog.main.api.exception;

import lombok.Data;

@Data
public class CommonException extends RuntimeException{
    private int code;
    public CommonException(){}
    public CommonException(String s,int code) {
        super(s);
        this.code = code;
    }
}
