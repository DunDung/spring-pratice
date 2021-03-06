package com.example.aopjojoldu;

import com.example.aopjojoldu.aop.Performance;
import com.example.aopjojoldu.board.entity.Board;
import com.example.aopjojoldu.board.repository.BoardRepository;
import com.example.aopjojoldu.board.service.BoardService;
import com.example.aopjojoldu.user.entity.User;
import com.example.aopjojoldu.user.repository.UserRepository;
import com.example.aopjojoldu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
public class AopJojolduApplication implements CommandLineRunner {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AopJojolduApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 100; i++) {
            boardRepository.save(new Board(i + "번째 게시글의 제목", i + "번째 게시글의 내용"));
            userRepository.save(new User(i + "@email.com", i + "번째 사용자"));
        }
    }

    @GetMapping("/boards")
    public List<Board> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @Bean
    public Performance performance() {
        return new Performance();
    }

}
