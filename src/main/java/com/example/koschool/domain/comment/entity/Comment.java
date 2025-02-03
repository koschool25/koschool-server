package com.example.koschool.domain.comment.entity;

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
@Table(name = "Comment")
public class Comment {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id", unique = true)
    private Long commentId;

    /**
     * 사용자 고유 id
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "member_id", nullable = false)
    private Member member;

    /**
     * 커뮤니티 글 고유 id
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "community_id", name = "community_id", nullable = false)
    private Community community;

    /**
     * 댓글 내용
     */
    @Column(name = "comment_content", nullable = false)
    private String commentContent;

}
