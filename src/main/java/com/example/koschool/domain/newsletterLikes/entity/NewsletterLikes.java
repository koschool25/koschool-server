package com.example.koschool.domain.newsletterLikes.entity;

import com.example.koschool.domain.member.entity.Member;
import com.example.koschool.domain.newsletter.entity.Newsletter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Newsletter_Likes")
public class NewsletterLikes {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "newsletter_likes_id", unique = true)
    private Long newsletterLikesId;

    /**
     * 뉴스레터 고유 id
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "newsletter_id", name = "newsletter_id", nullable = false)
    private Newsletter newsletter;

    /**
     * 사용자 고유 id
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "member_id", nullable = false)
    private Member member;

    /**
     * 좋아요 취소 여부
     */
    @Column(name = "likes_yn",  nullable = false)
    private Boolean likesYn;

}
