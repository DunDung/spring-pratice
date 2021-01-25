package com.dundung.demospring51.environment.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;

    //    @Autowired
//    BookRepository bookRepository;
    // test 환경일 때만 됨
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = applicationContext.getEnvironment();
        System.out.println(environment.getActiveProfiles());
        System.out.println(environment.getDefaultProfiles());
    }
}
