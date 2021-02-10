package com.dundung.demospring51.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunnerAop implements ApplicationRunner {

    @Autowired
    EventService eventService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("----");
        System.out.println("AOP");
        System.out.println("----");
        eventService.createEvent();
        eventService.publishEvent();
    }
}
