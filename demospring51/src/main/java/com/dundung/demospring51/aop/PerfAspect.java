package com.dundung.demospring51.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    // Around는 다용도 어노테이션
    @Around("@annotation(PerfLogging)")
    public Object logPerf(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println(System.nanoTime() - begin);
        return proceed;
    }

    // bean에도 적용가능 해당 bean 모든 public 메서드에 적용
    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("hello");
    }

}
