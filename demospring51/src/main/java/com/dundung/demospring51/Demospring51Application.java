package com.dundung.demospring51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demospring51Application {


    public static void main(String[] args) {
//        new SpringApplicationBuilder()
//                .sources(Demospring51Application.class)
//                .initializers(new ApplicationContextInitializer<GenericApplicationContext>() {
//                    @Override
//                    public void initialize(GenericApplicationContext applicationContext) {
//                        applicationContext.registerBean(MyService.class);
//                    }
//                })
//                .run();
        SpringApplication.run(Demospring51Application.class);
    }

}
