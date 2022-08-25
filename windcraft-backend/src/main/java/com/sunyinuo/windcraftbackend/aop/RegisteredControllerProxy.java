package com.sunyinuo.windcraftbackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 注册控制器增强类
 * @author sunyinuo
 */
@Component
@Aspect
@Slf4j
public class RegisteredControllerProxy {

    @Pointcut("execution(* com.sunyinuo.windcraftbackend.controller.RegisteredController.registered(..))")
    public void registeredPoint(){}

    @Around("registeredPoint()")
    public Object registeredLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("registered方法开始执行");

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("args :{}",arg);
        }
        Object object = joinPoint.proceed();

        log.info("return:{}",object);
        log.info("registered方法结束\n");
        return object;
    }
}
