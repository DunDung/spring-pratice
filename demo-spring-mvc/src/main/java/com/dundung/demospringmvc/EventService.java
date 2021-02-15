package com.dundung.demospringmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .name("스프링 웹 MVC 스터디 1차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 2, 15, 10, 0))
                .endDateTime(LocalDateTime.of(2020, 2, 15, 22, 0))
                .build();

        Event event2 = Event.builder()
                .name("스프링 웹 MVC 스터디 2차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 3, 15, 10, 0))
                .endDateTime(LocalDateTime.of(2020, 3, 15, 22, 0))
                .build();

        return Arrays.asList(event1, event2);
    }
}
