package com.sunyinuo.windcraftbackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * GetBanListController增强类
 * @author sunyinuo
 */
@Component
@Aspect
@Slf4j
public class GetBanListControllerProxy {
    @Pointcut("execution(* com.sunyinuo.windcraftbackend.controller.GetBanListController.getBanList(..))")
    public void getBanListPoint(){}

    @Around("getBanListPoint()")
    public Object GetBanListLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("GetBanList方法开始执行");
        Object object = joinPoint.proceed();
        log.info("return:{}",object);
        log.info("GetBanList方法结束\n");
        return object;
    }
}
