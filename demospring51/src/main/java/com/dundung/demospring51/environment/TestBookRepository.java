package com.dundung.demospring51.environment;

import com.dundung.demospring51.autowired.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("!prod")
public class TestBookRepository implements BookRepository {
}
