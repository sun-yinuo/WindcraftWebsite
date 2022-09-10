package com.sunyinuo.windcraftbackend.aop;

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

    @Pointcut("execution(* com.sunyinuo.windcraftbackend.controller.ApiController.getBanList(..))")
    public void getBanListPoint(){}

    @Pointcut("execution(* com.sunyinuo.windcraftbackend.controller.ApiController.getLoginState(..))")
    public void getLoginStatePoint(){}

    private final StopWatch getBanListStopWatch = new StopWatch("getBanList");
    private final StopWatch getLoginStateStopWatch = new StopWatch("getLoginStat");

    /**
     * 获取ban列表日志增强方法
     * @param joinPoint 切入点
     * @return obj
     * @throws Throwable 异常
     */
    @Around("getBanListPoint()")
    public Object getBanListLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("GetBanList方法开始执行");
        getBanListStopWatch.start();
        Object object = joinPoint.proceed();
        getBanListStopWatch.stop();
        log.info("return:{}",object);
        log.info("time:{}", getBanListStopWatch.prettyPrint());
        log.info("GetBanList方法结束\n");
        return object;
    }

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
