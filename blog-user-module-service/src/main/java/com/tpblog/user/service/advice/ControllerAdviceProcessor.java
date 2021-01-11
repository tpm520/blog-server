package com.tpblog.user.service.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviceProcessor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    protected MessageSource messageSource;
 
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public GenericResponse handleException(HttpServletRequest request, Exception ex)  {
        GenericResponse response = new GenericResponse();
        response.setCode(ex.getMessage());

        Throwable cause = ex.getCause();
        response.setMessage(cause.getMessage());
        return response;
    }
}