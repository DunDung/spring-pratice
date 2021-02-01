package com.dundung.demospring51.databinding;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

//@Component
// 빈등록이 가능
public class EventFormatter implements Formatter<Event> {

//    @Autowired
//    MessageSource messageSource;

    @Override
    public Event parse(String text, Locale locale) throws ParseException {
        return new Event(Integer.parseInt(text));
    }

    @Override
    public String print(Event object, Locale locale) {
        // 메세지 소스를 편하게 사용가능하다. 빈등록되기 때문
//        messageSource.getMessage("title", locale);
        return object.getId().toString();
    }
}
