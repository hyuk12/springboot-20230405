package com.web.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class ParamsAop {

    @Pointcut("@annotation(com.web.study.aop.annotation.ParamsAspect)")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        StringBuilder stringBuilder = new StringBuilder();

        // codeSignature : 파라미터 이름을 가져오기 위한 객체 없으면 들고 올 수 없다. (써보지 않으면 모르는 객체)
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        String[] parameterNames = codeSignature.getParameterNames();
        // 파라미터의 값 : Object[] args = joinPoint.getArgs();
        Object[] args = joinPoint.getArgs();

        // for 문을 통해 index 를 맞춰서 파라미터 이름과 파라미터 값을 매칭시킨다.
        for (int i = 0; i < parameterNames.length; i++) {
            if (i !=0 ){
                stringBuilder.append(", ");
            }
            stringBuilder.append(parameterNames[i]).append(": ").append(args[i]);
        }

        log.info("[ params ] >>> {}", stringBuilder.toString());

        return joinPoint.proceed();
    }
}
