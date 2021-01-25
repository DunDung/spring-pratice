package com.dundung.demospring51.applicationcontext.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class DunDungBookRepository implements BookRepository {
}
