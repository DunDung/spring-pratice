package com.dundung.demospring51.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // 파라미터로 전달되는 객체의 클래스 타입이 Event인지 검증
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "Empty title is not allowed");

        // ValidationUtils 없이도 가능
        Event event = (Event) target;
        if (event.getTitle() == null) {
            errors.rejectValue("title", "notempty", "Empty title is not allowed");
        }
    }
}
