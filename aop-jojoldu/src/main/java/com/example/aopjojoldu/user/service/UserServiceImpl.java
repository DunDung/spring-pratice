package com.example.aopjojoldu.user.service;

import com.example.aopjojoldu.user.entity.User;
import com.example.aopjojoldu.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public void updateUser(User user) throws Exception {
        repository.save(user);
    }
}
