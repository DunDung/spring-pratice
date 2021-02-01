package com.dundung.demospring51.databinding;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Converter 사용
        registry.addConverter(new EventConverter.StringToEventConverter());

        // Fomatter 사용
        registry.addFormatter(new EventFormatter());
    }

}
