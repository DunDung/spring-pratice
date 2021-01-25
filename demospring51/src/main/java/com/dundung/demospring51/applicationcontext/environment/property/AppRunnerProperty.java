package com.dundung.demospring51.applicationcontext.environment.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppRunnerProperty implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;

    @Value("${app.name}")
    String appName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = applicationContext.getEnvironment();
        System.out.println("property");
        System.out.println(environment.getProperty("app.name"));
        System.out.println(environment.getProperty("app.about"));
        System.out.println(appName);
    }
}
