package com.dundung.demospring51.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class AppRunnerSpel implements ApplicationRunner {

    // #은 표현식을 사용하는 방법
    @Value("#{1 + 1}")
    int value;

    @Value("#{'hello ' + 'world'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("hello")
    String hello;

    // $은 property를 참고하는 방법
    @Value("${my.value}")
    int myValue;

    // 표현식안에 property 사용하기
    @Value("#{${my.value} eq 100}")
    boolean inMyValue100;

    // bean에 있는 데이터 가져오기
    @Value("#{sample.data}")
    int sampleData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("SpEL");
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(myValue);
        System.out.println(inMyValue100);
        System.out.println(sampleData);

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("2 + 100");
        // ConversionService 사용
        Integer value = expression.getValue(Integer.class);
        System.out.println(value);
    }
}
