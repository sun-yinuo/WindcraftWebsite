package com.sunyinuo.windcraftbackend.aop.api;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * GetLoginStateController增强类
 * @author sunyinuo
 */
@Component
@Aspect
@Slf4j
public class GetLoginStateControllerProxy {
    @Pointcut("execution(* com.sunyinuo.windcraftbackend.controller.api.GetLoginStateController.getLoginState(..))")
    public void getLoginStatePoint(){}

    @Around("getLoginStatePoint()")
    public Object getLoginStateLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("getLoginState开始执行");
        Object object = joinPoint.proceed();
        log.info("return:{}", object);
        log.info("getLoginState结束 \n");
        return object;
    }
}
