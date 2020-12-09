package com.example.aopjojoldu.user.repository;

import com.example.aopjojoldu.user.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
