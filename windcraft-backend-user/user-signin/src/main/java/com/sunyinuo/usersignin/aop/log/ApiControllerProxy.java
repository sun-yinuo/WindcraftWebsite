package com.sunyinuo.usersignin.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * api控制器增强类
 * @author sunyinuo
 */
@Component
@Aspect
@Slf4j
public class ApiControllerProxy {


    @Pointcut("execution(* com.sunyinuo.usersignin.controller.ApiController.getLoginState(..))")
    public void getLoginStatePoint(){}

    private final StopWatch getLoginStateStopWatch = new StopWatch("getLoginStat");


    /**
     * 获取登陆状态日志增强方法
     * @param joinPoint 切入点
     * @return obj
     * @throws Throwable 异常
     */
    @Around("getLoginStatePoint()")
    public Object getLoginStateLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("getLoginState开始执行");

        getLoginStateStopWatch.start();
        Object object = joinPoint.proceed();
        getLoginStateStopWatch.stop();

        log.info("time:{}", getLoginStateStopWatch.prettyPrint());
        log.info("return:{}", object);
        log.info("getLoginState结束 \n");

        return object;
    }

}
