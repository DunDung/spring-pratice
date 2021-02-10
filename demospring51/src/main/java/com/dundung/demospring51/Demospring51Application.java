package com.dundung.demospring51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@PropertySource("classpath:/app.properties ")
@EnableAsync
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

        // 서버가 실행 후 자동으로 꺼지는 설정, 웹 서버가 기동되지 않음
//        SpringApplication app = new SpringApplication(Demospring51Application.class);
//        app.setWebApplicationType(WebApplicationType.NONE);
//        app.run(args);

        SpringApplication.run(Demospring51Application.class);
    }

}
