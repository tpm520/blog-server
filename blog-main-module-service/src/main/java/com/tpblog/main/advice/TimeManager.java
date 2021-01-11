package com.tpblog.main.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeManager {
    long start = 0l;
    @Pointcut("execution(public * com.tpblog..*.*(..))")
    public void point(){}

    @Before("point()")
    public void before(){
        start = System.currentTimeMillis();
    }

    @After("point()")
    public void after(JoinPoint joinPoint){
        Object target = joinPoint.getTarget();
        String typeName = target.getClass().getTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("-----------------------------------------");
        System.out.println("执行方法:"+typeName+"."+methodName+"()");
        System.out.println("方法耗时:"+(System.currentTimeMillis()-start)+"ms");
        System.out.println("-----------------------------------------");
    }
}
