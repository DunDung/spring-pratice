package com.dundung.demospring51;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class DunDungBookRepository implements BookRepository {
}
