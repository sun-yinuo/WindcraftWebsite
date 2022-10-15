package com.sunyinuo.windcraftbackendreport.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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
public class ApiControllerProxy {

    @Pointcut("execution(* com.sunyinuo.windcraftbackendreport.service.api.impl.FileUploadServiceImpl.fileUpload(..))")
    private void fileUploadPoint(){}

    private final StopWatch fileUploadStopWatch  = new StopWatch("fileUpload");

    /**
     * 当抛出异常时触发
     * @param e 异常
     */
    @AfterThrowing(throwing = "e", pointcut = "fileUploadPoint()")
    public void fileUploadAfterThrowing(Throwable e){
        log.error("fileUploadError:" , e);
    }

    /**
     * 日志环绕
     * @param joinPoint 切入点
     * @return obj
     * @throws Throwable 异常
     */
    @Around("fileUploadPoint()")
    public Object fileUploadAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("fileUpload方法开始执行");


        fileUploadStopWatch.start();
        Object object = joinPoint.proceed();
        fileUploadStopWatch.stop();

        log.info("return:{}", object);
        log.info("time:{}", fileUploadStopWatch.prettyPrint());
        log.info("fileUpload方法结束\n");

        return object;
    }

}
