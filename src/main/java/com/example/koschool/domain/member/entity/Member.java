package com.example.koschool.domain.member.entity;

import com.example.koschool.domain.comment.entity.Comment;
import com.example.koschool.domain.community.entity.Community;
import com.example.koschool.domain.communityLikes.entity.CommunityLikes;
import com.example.koschool.domain.enums.CategoryEnum;
import com.example.koschool.domain.member.dto.request.JoinMemberRequestDto;
import com.example.koschool.domain.newsletterLikes.entity.NewsletterLikes;
import com.example.koschool.domain.quizHistory.entity.QuizHistory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "Member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", unique = true, nullable = false)
    private Long memberId;

    /**
     * 사용자 id
     */
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    /**
     * 사용자 pw
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 사용자 뉴스레터 취향
     */
    @Column(name = "category_topic", nullable = false)
    private CategoryEnum categoryTopic;

    /**
     * 커뮤니티 글 올린 내역
     */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Community> communityList;

    /**
     * 커뮤니티 좋아요 내역
     */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<CommunityLikes> communityLikesList;

    /**
     * 커뮤니티 댓글 내역
     */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Comment> comment;

    /**
     * 뉴스레터 좋아요 내역
     */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<NewsletterLikes> newsletterLikesList;

    /**
     * 퀴즈 내역
     */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<QuizHistory> quizList;


    @Builder
    private Member(String id, String password, CategoryEnum categoryTopic) {
        this.id = id;
        this.password = password;
        this.categoryTopic = categoryTopic;
    }

    public static Member fromDtoToEntity(JoinMemberRequestDto joinMemberRequestDto) {
        return Member.builder()
            .id(joinMemberRequestDto.getId())
            .password(joinMemberRequestDto.getPassword())
            .categoryTopic(joinMemberRequestDto.getCategoryTopic())
            .build();
    }

}
