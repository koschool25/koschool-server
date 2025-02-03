package com.example.koschool.domain.quiz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Quiz")
public class Quiz {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    /**
     * 뉴스레터 id
     */
    @Column(name = "newsletterId")
    private Long newsletterId;

    /**
     * 수준
     */
    @Column(name = "level", nullable = false)
    private Integer level;

    /**
     * 질문
     */
    @Column(name = "question", nullable = false)
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
