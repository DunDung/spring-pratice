package com.dundung.springapplicationcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// ComponentScan에 basePackages와 basePackageClasses가 있는데 후자가 더 type-safe하다. 전자는 문자열로 지정해주기 때문
// 지정한 곳을 포함한 하위 패키지를 컴포넌트 스캔한다.
@ComponentScan(basePackageClasses = SpringapplicationcontextApplication.class)
public class ApplicationConfig {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository);
        return bookService;
    }
}
