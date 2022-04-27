package org.zerock.boardtest.aop;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//gradle에서 runtime only 일시 실행 중에만 어노테이션이 걸림 -> implimentaion으로 바꾸어 주면됨
@Aspect
@Log4j2
@Component
public class LogAdvice {

    //
    @Before("execution(* org.zerock.boardtest.service.ReplyService*.*(..))")
    public void printLog(JoinPoint joinPoint) {

        Object[] params = joinPoint.getArgs();

        log.info("--------------------------");
        log.info("--------------------------");
        log.info(Arrays.toString(params));
        log.info("--------------------------");
        log.info("--------------------------");

    }
}
