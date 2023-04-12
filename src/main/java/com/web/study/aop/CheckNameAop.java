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
public class CheckNameAop {

    @Pointcut("@annotation(com.web.study.aop.annotation.CheckNameAspect)")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();
        log.info("[name] >>> {}", joinPoint.getSignature().toShortString());

        return result;
    }
}
