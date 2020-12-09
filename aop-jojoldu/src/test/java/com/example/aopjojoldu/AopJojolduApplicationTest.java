package com.example.aopjojoldu;

import com.example.aopjojoldu.board.service.BoardService;
import com.example.aopjojoldu.user.entity.History;
import com.example.aopjojoldu.user.entity.User;
import com.example.aopjojoldu.user.repository.HistoryRepository;
import com.example.aopjojoldu.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AopJojolduApplicationTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryRepository historyRepository;

    @Test
    void findUsers() {
        assertThat(userService.getUsers().size()).isEqualTo(100);
    }

    @Test
    public void findBoards() {
        assertThat(boardService.getBoards().size()).isEqualTo(100);
    }

    @Test
    public void updateUsers() throws Exception {
        List<User> users = userService.getUsers();
        for (int i = 0; i < 5; i++) {
            User user = users.get(i);
            user.setEmail("jojoldu@gmail.com");
            userService.updateUser(user);
        }

        List<History> histories = historyRepository.findAll();
        assertThat(histories.size()).isEqualTo(5);
        assertThat(histories.get(0).getUserIdx()).isEqualTo(1L);
        assertThat(histories.get(1).getUserIdx()).isEqualTo(2L);
    }

}
