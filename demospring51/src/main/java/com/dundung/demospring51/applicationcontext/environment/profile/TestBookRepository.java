package com.dundung.demospring51.applicationcontext.environment.profile;

import com.dundung.demospring51.applicationcontext.autowired.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("!prod")
public class TestBookRepository implements BookRepository {
}
