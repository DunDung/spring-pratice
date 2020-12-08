package com.example.aopjojoldu;

import com.example.aopjojoldu.board.service.BoardService;
import com.example.aopjojoldu.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AopJojolduApplicationTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Test
    void findUsers() {
        assertThat(userService.getUsers().size()).isEqualTo(100);
    }

    @Test
    public void findBoards() {
        assertThat(boardService.getBoards().size()).isEqualTo(100);
    }

}
