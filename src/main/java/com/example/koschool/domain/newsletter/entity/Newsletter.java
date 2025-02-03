package com.example.koschool.domain.newsletter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Newsletter")
public class Newsletter {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    /**
     * 제목
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * 카테고리
     */
    @Column(name = "category", nullable = false)
    private String category;

    /**
     * AI 요약 내용
     */
    @Column(name = "summary", nullable = false)
    private String summary;

    /**
     * 좋아요 수
     */
    @Column(name = "likes", nullable = false)
    private Integer likes;

    /**
     * 원문 링크
     */
    @Column(name = "link")
    private String link;

    /**
     * 종목 이름
     */
    @Column(name = "stock")
    private String stock;

    /**
     * 날짜
     */
    @Column(name = "date")
    private LocalDate date;

}
