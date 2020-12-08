package com.example.aopjojoldu.board.service;

import com.example.aopjojoldu.board.entity.Board;
import com.example.aopjojoldu.board.repository.BoardRepository;
import com.example.aopjojoldu.common.SuperPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService extends SuperPerformance<Board> {

    @Autowired
    private BoardRepository repository;

    @Override
    public List<Board> findAll() {
        return repository.findAll();
    }
}
