package com.sunyinuo.bancrud.aop.log;

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

    @Pointcut("execution(* com.sunyinuo.bancrud.controller.ApiController.getBanList(..))")
    public void getBanListPoint(){}

    @Pointcut("execution(* com.sunyinuo.bancrud.controller.ApiController.getProhibitList(..))")
    public void getProhibitListPoint(){}

    @Pointcut("execution(* com.sunyinuo.bancrud.controller.ApiController.getWaringList(..))")
    private void getWaringListPoint(){}

    private final StopWatch getBanListStopWatch = new StopWatch("getBanList");
    private final StopWatch getProhibitListStopWatch = new StopWatch("getProhibitList");
    private final StopWatch getWaringListStopWatch = new StopWatch("getWaringList");

    /**
     * 获取ban列表日志增强方法
     * @param joinPoint 切入点
     * @return obj
     * @throws Throwable 异常
     */
    @Around("getBanListPoint()")
    public Object getBanListLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("GetBanList开始执行");

        getBanListStopWatch.start();
        Object object = joinPoint.proceed();
        getBanListStopWatch.stop();

        log.info("return:{}",object);
        log.info("time:{}", getBanListStopWatch.prettyPrint());
        log.info("GetBanList方法结束\n");
        return object;
    }

    @Around("getProhibitListPoint()")
    public Object getProhibitListLogAround(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("getProhibitList开始执行");

        getProhibitListStopWatch.start();
        Object object = joinPoint.proceed();
        getProhibitListStopWatch.stop();

        log.info("time:{}", getProhibitListStopWatch.prettyPrint());
        log.info("return:{}", object);
        log.info("getProhibitList结束 \n");

        return object;
    }

    @Around("getWaringListPoint()")
    public Object getWaringListLogAround(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("getWaringList开始执行");

        getWaringListStopWatch.start();
        Object object = joinPoint.proceed();
        getWaringListStopWatch.stop();

        log.info("time:{}", getWaringListStopWatch.prettyPrint());
        log.info("return:{}", object);
        log.info("getWaringList结束 \n");

        return object;
    }

}
