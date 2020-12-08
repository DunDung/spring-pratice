package com.example.aopjojoldu.user.service;

import com.example.aopjojoldu.common.SuperPerformance;
import com.example.aopjojoldu.user.entity.User;
import com.example.aopjojoldu.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends SuperPerformance<User> {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
