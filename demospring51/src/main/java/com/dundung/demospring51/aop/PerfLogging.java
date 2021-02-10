package com.dundung.demospring51.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션 클래스를 어디까지 유지할 것인가.
// CLASS: 바이트코드까지 남아있는다.
// SOURCE: 컴파일 후 사라짐
// RUNTIME: 런타임까지 유지
// DEFAULT가 CLASS
@Retention(RetentionPolicy.CLASS)
@Documented
@Target(ElementType.METHOD)
public @interface PerfLogging {
}
