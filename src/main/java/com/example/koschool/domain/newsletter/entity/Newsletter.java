package com.example.koschool.domain.newsletter.entity;

import com.example.koschool.domain.enums.CategoryEnum;
import com.example.koschool.domain.newsletterLikes.entity.NewsletterLikes;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Newsletter")
public class Newsletter {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private CategoryEnum category;

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
     * 뉴스레터 좋아요
     */
    @OneToMany(mappedBy = "newsletter", cascade = CascadeType.ALL)
    private List<NewsletterLikes> newsletterLikesList;

    /**
     * 종목 코드
     */
    @Column(name = "stock_code")
    private String stockCode;

    /**
     * 날짜
     */
    @Column(name = "date")
    private LocalDate date;

}
