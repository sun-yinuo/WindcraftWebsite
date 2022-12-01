package com.sunyinuo.usersignin.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 注册控制器增强类
 * @author sunyinuo
 */
@Component
@Aspect
@Slf4j
public class RegisteredControllerProxy {

    @Pointcut("execution(* com.sunyinuo.usersignin.controller.RegisteredController.registered(..))")
    public void registeredPoint(){}

    private final StopWatch registeredStopWatch = new StopWatch("registered");

    @Around("registeredPoint()")
    public Object registeredLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("registered方法开始执行");
        registeredStopWatch.start();

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("args :{}",arg);
        }
        Object object = joinPoint.proceed();

        log.info("return:{}",object);
        registeredStopWatch.stop();

        log.info("time:{}" , registeredStopWatch.prettyPrint());
        log.info("registered方法结束\n");
        return object;
    }
}
