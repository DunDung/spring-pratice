package com.dundung.demospring51.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class DunDungBookRepository implements BookRepository {
}
