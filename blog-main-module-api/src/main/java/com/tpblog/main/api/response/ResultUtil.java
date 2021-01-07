package com.tpblog.main.api.response;


import com.tpblog.main.api.enums.ResponseStatusCode;

public class ResultUtil {

    /**
     * 请求成功
     * @param data
     * @return
     */
    public static Result success(Object data){
        return new Result(
                ResponseStatusCode.SUCCESS.getCode(),
                ResponseStatusCode.SUCCESS.getMessage(),
                data);
    }

    /**
     * 请求失败
     * @return
     */
    public static Result failed(){
        return new Result(
                ResponseStatusCode.FAILED.getCode(),
                ResponseStatusCode.FAILED.getMessage());
    }

    /**
     * 数据未找到
     * @return
     */
    public static Result not(){
        return new Result(
                ResponseStatusCode.NOT_FIND.getCode(),
                ResponseStatusCode.NOT_FIND.getMessage());
    }

    /**
     * 未登录
     * @return
     */
    public static Result notLogin(){
        return new Result(ResponseStatusCode.NOT_LOGIN.getCode(),
                ResponseStatusCode.NOT_LOGIN.getMessage());
    }
}
