package com.example.koschool.domain.question.entity;

import com.example.koschool.domain.enums.LevelEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Question")
public class Question {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id", unique = true, nullable = false)
    private Long questionId;

    /**
     * 수준
     */
    @Column(name = "level", nullable = false)
    private LevelEnum level;

    /**
     * 질문
     */
    @Column(name = "question", unique = true, nullable = false)
    private String question;

    /**
     * 정답
     */
    @Column(name = "answer", nullable = false)
    private String answer;

    /**
     * 해설
     */
    @Column(name = "explanation", nullable = false)
    private String explanation;

    /**
     * 오답1
     */
    @Column(name = "wrongAnswer1", nullable = false)
    private String wrongAnswer1;

    /**
     * 오답2
     */
    @Column(name = "wrongAnswer2", nullable = false)
    private String wrongAnswer2;

    /**
     * 오답3
     */
    @Column(name = "wrongAnswer3", nullable = false)
    private String wrongAnswer3;
}
