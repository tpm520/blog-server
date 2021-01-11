package com.tpblog.user.api.exception;

public abstract class ConsumerException extends RuntimeException{
    private Integer code;
    private String causeMsg;
    public ConsumerException() {
        super();
    }
    public ConsumerException(Integer code,String message,String cause){
        super(code.toString(),new Throwable(message+";"+cause));
    }
}
