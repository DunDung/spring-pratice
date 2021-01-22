package com.dundung.demospring51.beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("proto");
        System.out.println(applicationContext.getBean(Proto.class));
        applicationContext.getBean(Proto.class);
        applicationContext.getBean(Proto.class);
        System.out.println("single");
        applicationContext.getBean(Single.class);
        applicationContext.getBean(Single.class);
        applicationContext.getBean(Single.class);

    }
}
