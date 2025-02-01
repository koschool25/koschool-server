package com.example.koschool.domain.quiz.entity;

import com.example.koschool.domain.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Quiz")
public class Quiz {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quiz_id", unique = true, nullable = false)
    private Long quizId;

    /**
     * 사용자 고유 id
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "member_id", name = "member_id", nullable = false)
    private Member member;

    /**
     * 이용 날짜
     */
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    /**
     * 정답률
     */
    @Column(name = "rate", nullable = false)
    private String rate;

    /**
     * 오답 문항 내역
     */
    @Column(name = "history")
    private String history;
}
