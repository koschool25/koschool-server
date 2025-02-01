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
    @Column(name = "newsletter_id", unique = true, nullable = false)
    private Long newsletterId;

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
    @Column(name = "content", nullable = false)
    private String content;

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
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<NewsletterLikes> newsletterLikesList;

}
