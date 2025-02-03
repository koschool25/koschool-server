package com.example.koschool.domain.quiz.repository;

import com.example.koschool.domain.quiz.entity.Quiz;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuizRepository extends JpaRepository<Quiz, String> {

    @Query("SELECT q FROM Quiz q WHERE q.newsletterId IS NULL AND q.level = :level ORDER BY FUNCTION('RAND')")
    List<Quiz> findRandomQuizzesByLevel(@Param("level") String level, Pageable pageable);


}
