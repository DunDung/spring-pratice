package com.dundung.demospring51.messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunnerMessageSource implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {
            String koreanMessage = messageSource.getMessage("greeting", new String[]{"dundung"}, Locale.KOREA);
            String defaultMessage = messageSource.getMessage("greeting", new String[]{"dundung"}, Locale.getDefault());
            System.out.println("message source");
            System.out.println(messageSource.getClass());
            System.out.println(defaultMessage);
            System.out.println(koreanMessage);
            System.out.println();
            Thread.sleep(1000);
        }
    }
}
