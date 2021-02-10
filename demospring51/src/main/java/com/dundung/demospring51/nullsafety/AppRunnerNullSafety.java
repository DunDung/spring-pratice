package com.dundung.demospring51.nullsafety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunnerNullSafety implements ApplicationRunner {

    @Autowired
    NullSafetyService nullSafetyService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nullSafetyService.create(null);
    }
}
