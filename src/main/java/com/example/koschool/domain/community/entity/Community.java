package com.example.koschool.domain.community.entity;

import com.example.koschool.domain.comment.entity.Comment;
import com.example.koschool.domain.common.BaseEntity;
import com.example.koschool.domain.communityLikes.entity.CommunityLikes;
import com.example.koschool.domain.member.entity.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "Community")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Community extends BaseEntity {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "community_id", unique = true)
    private Long communityId;

    /**
     * 사용자 고유 id
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "member_id", nullable = false)
    private Member member;

    /**
     * 제목
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * 내용
     */
    @Column(name = "content", nullable = false)
    private String content;

    /**
     * 좋아요 수
     */
    @Column(name = "likes", nullable = false)
    private Integer likes;

    /**
     * 댓글 수
     */
    @Column(name = "comments", nullable = false)
    private Integer comments;

    /**
     * 좋아요
     */
    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private List<CommunityLikes> communityLikesList;

    /**
     * 댓글
     */
    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private List<Comment> commentList;


}
