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
        //获取参数
        Object[] args = joinPoint.getArgs();
        //start日志
        log.info("registered方法开始执行");
        //方法入参日志
        for (Object arg : args) {
            log.info("args :{}",arg);
        }
        //业务代码执行
        Object object = joinPoint.proceed();
        //end日志
        log.info("registered方法结束");
        return object;
    }
}
