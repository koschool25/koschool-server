package com.example.koschool.domain.communityLikes.entity;

import com.example.koschool.domain.community.entity.Community;
import com.example.koschool.domain.member.entity.Member;
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
@Table(name = "Community_Likes")
public class CommunityLikes {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "community_likes_id", unique = true)
    private Long communityLikesId;

    /**
     * 커뮤니티 글 고유 id
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "community_id", name = "community_id", nullable = false)
    private Community community;

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
