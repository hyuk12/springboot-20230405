package com.web.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ReturnDataAop {

    @Pointcut("@annotation(com.web.study.aop.annotation.ReturnDataAspect)")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();

        log.info("[ Return Data ] >>> {}: {}", joinPoint.toShortString(), result);

        return result;
    }
}
