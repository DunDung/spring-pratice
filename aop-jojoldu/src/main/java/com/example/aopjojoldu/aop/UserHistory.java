package com.example.aopjojoldu.aop;

import com.example.aopjojoldu.user.entity.History;
import com.example.aopjojoldu.user.entity.User;
import com.example.aopjojoldu.user.repository.HistoryRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class UserHistory {

    @Autowired
    private HistoryRepository historyRepository;

    @Pointcut("execution(* com.example.aopjojoldu.user.service.UserService.updateUser(*)) && args(user)")
    public void updateUser(User user) {
    }

    @AfterReturning("updateUser(user)")
    public void saveHistory(User user) {
        historyRepository.save(new History(user.getIdx(), new Date()));
    }
}
