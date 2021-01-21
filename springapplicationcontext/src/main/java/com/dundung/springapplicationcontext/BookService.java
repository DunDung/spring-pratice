package com.dundung.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;

public class BookService {

    // 빈으로만 등록되면 @Autowired 의존성은 주입이 된다.
    @Autowired
    BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
