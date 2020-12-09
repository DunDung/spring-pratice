package com.example.aopjojoldu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Performance {

    // Advice -> Around는 실행 전과 후에 행동이 필요할 때 사용, 그래서 proceed가 꼭 있어야 한다.
    // proceed()를 수행해야만 타겟 메서드가 실행된다.
    @Around("execution(* com.example.aopjojoldu.board.service.BoardService.getBoards(..))")
    public Object calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("수행 시간: " + (end - start));
        } catch (Throwable throwable) {
            System.out.println("Exeception!");
        }
        return result;
    }
}
