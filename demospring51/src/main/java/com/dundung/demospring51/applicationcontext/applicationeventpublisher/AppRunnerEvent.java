package com.dundung.demospring51.applicationcontext.applicationeventpublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AppRunnerEvent implements ApplicationRunner {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Event Publisher");
        applicationEventPublisher.publishEvent(new MyEvent(100, this));
    }
}
