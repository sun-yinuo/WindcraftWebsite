package com.sunyinuo.reportgame.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author sunyinuo
 */
@Component
@Aspect
@Slf4j
public class ReportServiceProxy {

    @Pointcut("execution(* com.sunyinuo.reportgame.service.impl.ReportServiceImpl.report(..))")
    private void reportServicePoint(){}

    private final StopWatch reportStopWatch  = new StopWatch("report");

    /**
     * 日志
     */
    @Around("reportServicePoint()")
    public Object fileUploadAfterThrowing(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("report方法开始执行");
        reportStopWatch.start();
        Object object = joinPoint.proceed();
        reportStopWatch.stop();

        log.info("return:{}", object);
        log.info("time:{}", reportStopWatch.prettyPrint());
        log.info("report方法结束");

        return object;
    }
}
