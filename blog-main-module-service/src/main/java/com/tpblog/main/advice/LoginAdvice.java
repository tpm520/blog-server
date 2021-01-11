package com.tpblog.main.advice;


import com.tpblog.main.api.annotation.RequireLogin;
import com.tpblog.main.api.enums.ResponseStatusCode;
import com.tpblog.main.api.exception.LoginException;
import com.tpblog.main.api.response.Result;
import com.tpblog.main.utils.LoginCheck;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class LoginAdvice {

    @Autowired
    private LoginCheck loginCheck;

    @Pointcut("execution(public * com.tpblog..*.*(..))")
    public void point(){}

    /**
     * 拦截登录注解 RequireLogin
     * @param joinPoint
     */
    @Before("point()")
    public void before(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        String methodName = joinPoint.getSignature().getName();
        Method[] methods = target.getClass().getMethods();
        Method method = null;
        for (Method m:methods) {
            if (methodName.equals(m.getName())) {
                method = m;
            }
        }
        boolean annotationPresent = method.isAnnotationPresent(RequireLogin.class);
        if (annotationPresent) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            Result login = loginCheck.isLogin(request);
            // 用户必须登录
            if (login != null) {
                throw new LoginException("未登录", ResponseStatusCode.NOT_LOGIN.getCode());
            }
        }
    }
}
