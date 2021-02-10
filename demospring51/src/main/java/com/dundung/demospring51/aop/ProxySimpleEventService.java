//package com.dundung.demospring51.aop;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//
//@Primary
//@Service
//public class ProxySimpleEventService implements EventService {
//
//    @Autowired
//    SimpleEventService simpleEventService;
//
//    @Override
//    public void createEvent() {
//        long begin = System.nanoTime();
//        simpleEventService.createEvent();
//        System.out.println(System.nanoTime() - begin);
//    }
//
//    @Override
//    public void publishEvent() {
//        long begin = System.nanoTime();
//        simpleEventService.publishEvent();
//        System.out.println(System.nanoTime() - begin);
//    }
//
//    @Override
//    public void deleteEvent() {
//        simpleEventService.deleteEvent();
//    }
//}
