package com.example.koschool.domain.quizHistory.repository;

import com.example.koschool.domain.quizHistory.entity.QuizHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizHistoryRepository extends JpaRepository<QuizHistory, String> {

}
