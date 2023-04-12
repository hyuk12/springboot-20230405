package com.web.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class TimerAop {

    // 접근지정자 public 은 생략이 가능하다.
    @Pointcut("execution(* com.web.study..*.*(..))")
    private void pointCut() {}

    @Pointcut("@annotation(com.web.study.aop.annotation.TimerAspect)")
    private void annotationPointCut() {}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 전처리
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed(); // proceed() : 핵심 기능 수행(method 호출)
        // 후처리
        stopWatch.stop();
        log.info("[run time] >> {} : {}", joinPoint.getSignature().toShortString(), stopWatch.getTotalTimeSeconds());

        return result;
    }
}
