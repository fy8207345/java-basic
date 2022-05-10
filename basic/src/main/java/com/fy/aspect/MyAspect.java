package com.fy.aspect;

import com.fy.annotation.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.fy..*.*(..)) && @target(com.fy.annotation.MyAnnotation))")
    public Object before(ProceedingJoinPoint joinPoint){
        try {
            log.info("before: {}", joinPoint);
            return joinPoint.proceed();
        }catch (Throwable e){
            log.info("err: ", e);
        }
        return null;
    }
}
