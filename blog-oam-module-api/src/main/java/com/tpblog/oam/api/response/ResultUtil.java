package com.tpblog.oam.api.response;


import com.tpblog.oam.api.enums.ResponseStatusCode;

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
                ResponseStatusCode.NOT.getCode(),
                ResponseStatusCode.NOT.getMessage());
    }
}
