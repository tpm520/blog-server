package com.tpblog.user.api.exception;

import com.tpblog.user.api.enums.ResponseStatusCode;

public class ExceptionUtil{
    /**
     * 注册失败
     */
    public static class RegisterFailed extends ConsumerException{
        public RegisterFailed(String cause) {
            super(ResponseStatusCode.RegisterError.getCode(),
                    ResponseStatusCode.RegisterError.getMessage(),
                    cause);
        }
    }

    /**
     * 登录失败
     */
    public static class LoginFailed extends ConsumerException{
        public LoginFailed(String cause){
            super(ResponseStatusCode.LoginError.getCode(),
                    ResponseStatusCode.LoginError.getMessage(),
                    cause);
        }
    }
}
