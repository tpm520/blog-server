package com.tpblog.main.controller.exception;

import com.tpblog.main.api.exception.CommonException;
import com.tpblog.main.api.response.ResultException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常响应
 */
@ControllerAdvice
public class CommonExceptionController {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultException handlerException(HttpServletRequest request, Exception e){
        CommonException commonException = (CommonException) e;
        String method = request.getMethod();
        String requestURI = request.getRequestURL().toString();

        ResultException resultException = new ResultException();
        resultException.setMessage(commonException.getMessage());
        resultException.setCode(commonException.getCode());
        resultException.setUrl(requestURI);
        resultException.setMethod(method);
        return resultException;
    }
}
