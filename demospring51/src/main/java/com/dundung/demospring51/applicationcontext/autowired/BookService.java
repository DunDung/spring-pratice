package com.dundung.demospring51.applicationcontext.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookService {

    @Autowired
    BookRepository myBookRepository;
//    @Autowired
//    List<BookRepository> bookRepositories;

    @PostConstruct
    public void setUp() {
        System.out.println(myBookRepository.getClass());
    }
}
