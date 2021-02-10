package com.dundung.demospring51.nullsafety;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class NullSafetyService {

    @NonNull
    public String create(@NonNull String name) {
        return "hello" + name;
    }
}
