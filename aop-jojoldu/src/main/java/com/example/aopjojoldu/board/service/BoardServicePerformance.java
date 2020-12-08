package com.example.aopjojoldu.board.service;

import com.example.aopjojoldu.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary // 2개의 BoardService 중 우선 순위가 높은 Bean으로 지정
public class BoardServicePerformance implements BoardService {

    @Autowired
    // 자기 자신을 포함해서 BoardService Bean이 2개이기에 @Qualifier로 Bean 지정
    @Qualifier("boardServiceImpl")
    private BoardService boardService;

    @Override
    public List<Board> getBoards() {
        long start = before();
        List<Board> boards = boardService.getBoards();
        after(start);

        return boards;
    }

    private long before() {
        return System.currentTimeMillis();
    }

    private void after(long start) {
        long end = System.currentTimeMillis();
        System.out.println("수행 시간 : " + (end - start));
    }
}