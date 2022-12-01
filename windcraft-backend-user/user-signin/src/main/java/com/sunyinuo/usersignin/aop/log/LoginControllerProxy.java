package com.sunyinuo.usersignin.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 登陆控制器增强类
 * @author sunyinuo
 */
@Component
@Aspect
@Slf4j
public class LoginControllerProxy {
    @Pointcut("execution(* com.sunyinuo.usersignin.controller.LoginController.login(..))")
    public void loginPoint(){}

    private final StopWatch loginStopWatch = new StopWatch("login");

    @Around("loginPoint()")
    public Object loginLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取参数
        Object[] args = joinPoint.getArgs();

        log.info("login方法开始执行");
        loginStopWatch.start();

        //方法入参日志
        for (Object arg : args) {
            log.info("args:{}",arg);
        }

        Object object = joinPoint.proceed();

        log.info("return:{}" ,object);
        loginStopWatch.stop();

        log.info("time:{}", loginStopWatch.prettyPrint());
        log.info("login方法结束\n");
        return object;
    }
}
